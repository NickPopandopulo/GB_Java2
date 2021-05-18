package lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {

    private static DataInputStream in;
    private static DataOutputStream out;
    private static final Scanner scanner = new Scanner(System.in);
    private static volatile boolean isShutDown = false;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(ServerConstants.PORT)) {

            System.out.println("Server started. Wait for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            // Поток для получения сообщений от клиента
            receivingFromClient();

            // Поток для передачи сообщений клиенту
            sendingToClient();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void receivingFromClient() {
        new Thread(() -> {
            try {
                while (true) {
                    String strFromClient = in.readUTF();
                    // Если поймали STOP_WORD
                    if (strFromClient.equalsIgnoreCase(ServerConstants.STOP_WORD)) {
                        isShutDown = true;
                        break;
                    }
                    System.out.println("[Client]: " + strFromClient);
                }
                System.out.println("Receiving is closed.");
                closeConnection();
            } catch (IOException e) {
                if (isShutDown) {
                    System.out.println("Receiving is closed.");
                } else {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void sendingToClient() {
        new Thread(() -> {
            try {
                while (true) {
                    String strToClient;
                    // Ждем непустую строку в консоли
                    if (!(strToClient = scanner.nextLine().trim()).equals("")) {
                        // Если ввели STOP_WORD
                        if (strToClient.equalsIgnoreCase(ServerConstants.STOP_WORD)) {
                            isShutDown = true;
                            out.writeUTF(ServerConstants.STOP_WORD);
                            break;
                        }
                        out.writeUTF(strToClient);
                    }
                }
                System.out.println("Sending is closed.");
                closeConnection();
            } catch (IOException e) {
                if (isShutDown) {
                    System.out.println("Sending is closed.");
                } else {
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
