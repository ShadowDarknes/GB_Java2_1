package lesson7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private final int PORT = 8189;
    private List<ClientHandler> clients;
    private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            authService = new AuthService();
            authService.start();
            clients = new ArrayList<>();
            while (true) {
                System.out.println("Server awaits clients");
                Socket socket = server.accept();
                System.out.println("Client connected");
                new ClientHandler(this, socket);
            }
        } catch (IOException ex) {
            System.out.println("Server error");
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }


    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public synchronized void broadcast(String s, String msg) {
        if (msg.startsWith("/w")) adresMes(s,msg);
        else
            for (ClientHandler client : clients) {
                client.sendMsg(s);
            }
    }

    public synchronized boolean isNickLogged(String nick) {
        for (ClientHandler client : clients) {
            if (client.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    private void adresMes(String fromNick, String msg) {
        String[] mesAdres = msg.split(" ");
        if (mesAdres.length < 3) return;

        String toNick = mesAdres[1];
        String mess = msg.substring(toNick.length() + 3);

        for (ClientHandler o : clients) {
            String clientNick = o.getName();
            if (clientNick.equals(toNick) || clientNick.equals(fromNick))
                o.sendMsg("from: " + fromNick + " to: " + toNick + " " + mess);
        }
    }


}
