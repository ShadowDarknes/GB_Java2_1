package HomeWork_L2_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chats extends JFrame {
    private JTextField jtfMessage;
     private JTextArea jtaTextAreaMessage;

    public Chats() throws HeadlessException {

        setBounds(600, 300, 600, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jtaTextAreaMessage = new JTextArea();
        jtaTextAreaMessage.setEditable(false);
        jtaTextAreaMessage.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jtaTextAreaMessage);
        add(jsp, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Отправить");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);
        jtfMessage = new JTextField("Введите ваше сообщение: ");
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);
        jbSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // если имя клиента, и сообщение непустые, то отправляем сообщение
                if (!jtfMessage.getText().trim().isEmpty() ) {
                    sendMsg();
                    // фокус на текстовое поле с сообщением
                    jtfMessage.grabFocus();
                }
            }
        });
        // при фокусе поле сообщения очищается
        jtfMessage.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfMessage.setText("");
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void sendMsg(){
    String messageSTR = jtfMessage.getText();
    jtaTextAreaMessage.append(messageSTR);
    jtaTextAreaMessage.append("\n");
    jtfMessage.setText("");
    }

    public static void main(String[] args) {
        new Chats();
    }

}
