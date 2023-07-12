package JavaNet;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import MyTools.PrintTools;

public class TCP_Server implements Runnable {
    private Socket client = null;
    private Scanner scanner = null;
    private PrintStream out = null;
    private Boolean flag = true;
    private static List<Socket> clientList = new ArrayList<Socket>();

    public TCP_Server(Socket client) throws IOException {
        this.client = client;
        this.scanner = new Scanner(client.getInputStream());
        this.scanner.useDelimiter("\n");
        this.out = new PrintStream(client.getOutputStream());
    }

    @Override
    public void run() {
        while (this.flag) {
            if (this.scanner.hasNext()) {// if client has input
                String str = scanner.next().trim();
                if (str.equalsIgnoreCase("byebye")) {
                    out.println("[ECHO]: GoodBye!");
                    flag = false;
                } else {
                    if (str.contains("[B]")) {// call boardcast method
                        // remove [B] from str in any position
                        str = str.replace("[B]", "");
                        if (str.isEmpty()) {
                            out.println("[ECHO]: The Input Cannot Be Empty!");
                        } else
                            Boardcast(str);
                    } else {
                        out.println("[ECHO]: " + str);
                        PrintTools.println("Client " + client.getInetAddress().getHostAddress() + " says: " + str,
                                PrintTools.ANSI_Pink);
                    }

                }
            }
        }
        try {
            scanner.close();
            out.close();
            client.close();
            RemoveClient(client);
            System.out.println("Client " + client.getInetAddress().getHostAddress() + " disconnected.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void RemoveClient(Socket client) {
        for (Socket socket : clientList) {
            if (socket == client) {
                clientList.remove(socket);
                break;
            }
        }
    }

    /**
     * Boardcast message to all clients
     * 
     * @param str
     */
    public static void Boardcast(String str) {
        for (Socket socket : clientList) {
            try {
                PrintStream out = new PrintStream(socket.getOutputStream());
                out.println("[Boardcast]: " + str);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PrintTools.println("Boardcast message: " + str, PrintTools.ANSI_Blue);
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(TCP_Client.port);
        PrintTools.println("Server is running, waiting for client to connect...");
        Boolean flag = true;

        while (flag) {
            Socket client = server.accept();
            clientList.add(client);
            Boardcast("Client " + client.getInetAddress().getHostAddress() + " joined.");
            PrintTools.println("Client " + client.getInetAddress().getHostAddress() + " connected.", PrintTools.ANSI_Green);
            new Thread(new TCP_Server(client)).start();
        }
        server.close();
    }
}
