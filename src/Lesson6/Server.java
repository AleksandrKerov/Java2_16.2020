package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static ServerSocket server;
    static Socket socket;
    static final int PORT = 8190;
    private static DataOutputStream out;
    private static DataInputStream in;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client connected");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread writeToClient = new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF(scanner.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            writeToClient.setDaemon(true);
            writeToClient.start();

            while (true) {
                String str = in.readUTF();
                if (str.equals("/end")) {
                    System.out.println("Client disconnected");
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Client: " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

