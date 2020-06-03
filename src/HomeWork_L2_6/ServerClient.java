package HomeWork_L2_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

     public class ServerClient {
        final static String IP_ADRESS = "127.0.0.1";
        final static int PORT = 8189;
        static ServerSocket server = null;
        static Socket socket = null;
        static DataInputStream in = null;
        static DataOutputStream out = null;
        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args)  {

            //после запуска мы определим есть ли запущенный сервер
            //если нет, то мы будем являтся серверо для остальных
            if (startServer()) {
                System.out.println("Я сервер");
                //ждем подключения клиента
                try {
                    socket = server.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                    closeSeason();
                }
            } else {
                System.out.println("Я клиент");
                try {
                    socket = new Socket(IP_ADRESS, PORT);
                } catch (IOException e) {
                    e.printStackTrace();
                    closeSeason();
                }
            }
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                closeSeason();
            }
            //////////////////////////////////////////////////////////
            Thread task = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (!Thread.interrupted()) {
                            String str = in.readUTF();
                            System.out.println(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        closeSeason();
                    }
                }
            });
            task.start();
            //////////////////////////////////////////////////////////
            while (true) {
                String msg = scanner.nextLine();
                if (msg.equals("/end")) break;
                sendMessage(msg);
            }
            task.interrupt();
        }

        public static boolean startServer() {
            try {
                server = new ServerSocket(PORT);
            } catch (IOException e) {
                // e.printStackTrace();
                return false;
            }
            return true;
        }

        public static void closeSeason() {
            try {
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                    out = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (!socket.isClosed()) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (!server.isClosed()) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void sendMessage(String msg) {
            try {
                out.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
