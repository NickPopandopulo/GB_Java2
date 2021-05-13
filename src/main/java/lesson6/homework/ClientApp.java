package lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static final Scanner scanner = new Scanner(System.in);
    private static volatile boolean isServerShutDown = false;

    public static void main(String[] args) {
        try {
            socket = new Socket(ServerConstants.HOST, ServerConstants.PORT);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            // Поток для получения сообщений от сервера
            receivingFromServer();

            // Поток для передачи сообщений серверу
            sendingToServer();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void receivingFromServer() {
        new Thread(() -> {
            try {
                while (true) {
                    String strFromServer = in.readUTF();
                    // Если поймали STOP_WORD
                    if (strFromServer.equalsIgnoreCase(ServerConstants.STOP_WORD)) {
                        System.out.println("Server has shut down.");
                        isServerShutDown = true;
                        break;
                    }
                    System.out.println("[Server]: " + strFromServer);
                }
                closeConnection();
            } catch (IOException e) {
                if (!isServerShutDown) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void sendingToServer() {
        new Thread(() -> {
            try {
                while (true) {
                    String strToServer;
                    // Ждем непустую строку в консоли
                    if (!(strToServer = scanner.nextLine().trim()).equals("")) {
                        // Если ввели STOP_WORD
                        if (strToServer.equalsIgnoreCase(ServerConstants.STOP_WORD)) {
                            isServerShutDown = true;
                            out.writeUTF(ServerConstants.STOP_WORD);
                            System.out.println("Server has shut down.");
                            break;
                        }
                        out.writeUTF(strToServer);
                    }
                }
            } catch (IOException e) {
                if (!isServerShutDown) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
