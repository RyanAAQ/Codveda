package LevelThree.ChattApp;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started on port 5000...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Someone connected.");
            new Thread(new ClientHandler(socket)).start();
        }
    }

    static synchronized void addClient(PrintWriter out) {
        clients.add(out);
    }

    static synchronized void removeClient(PrintWriter out) {
        clients.remove(out);
    }

    static synchronized void broadcast(String message) {
        for (PrintWriter client : clients) {
            client.println(message);
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            PrintWriter out = null;
            String name = null;

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Enter your name:");
                name = in.readLine();
                if (name == null) {
                    return;
                }

                addClient(out);
                broadcast(name + " joined the chat.");

                String message;
                while ((message = in.readLine()) != null) {
                    broadcast(name + ": " + message);
                }

            } catch (IOException e) {
                System.out.println("Lost connection with a client.");
            } finally {
                if (name != null) {
                    removeClient(out);
                    broadcast(name + " left the chat.");
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    // nothing to do here
                }
            }
        }
    }
}
