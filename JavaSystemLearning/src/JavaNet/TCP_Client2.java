package JavaNet;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import MyTools.PrintTools;

public class TCP_Client2 {
    static final int port = 8080;
    static final String serverIP = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        PrintTools.println("Trying to connect to server...");
        socket = TryConnection();

        PrintTools.println("Please input message to send to server.");
        Scanner ServerMessage = new Scanner(socket.getInputStream());// client input stream
        Scanner userInputScanner = new Scanner(System.in);
        ServerMessage.useDelimiter("\n");
        PrintStream clientOut = new PrintStream(socket.getOutputStream());// client output stream
        String userInput = null;
        // FutureTask<String> userInputTask = new FutureTask<>(new
        // InputReciever(userInputScanner));
        Boolean flag = true;
        // if (ServerMessage.hasNext()) {// if client has massage
        // String echo = ServerMessage.next().trim();
        // System.clientOut.println(echo);
        // }

        new Thread(new ServerReciever(ServerMessage)).start();

        // new Thread(userInputTask).start();
        while (flag) {
            // try {
            // userInput = userInputTask.get();
            // } catch (InterruptedException | ExecutionException e) {
            // e.printStackTrace();
            // }
            userInput = userInputScanner.nextLine();
            if (userInput.length() > 0) {

                clientOut.println(userInput);// send message to server?
                socket = TryConnection();
                PrintTools.println("Send");
            } else {
                PrintTools.println("The Input Cannot Be Empty!", PrintTools.ANSI_Yellow);
            }

            if (userInput.equalsIgnoreCase("byebye")) {
                flag = false;
            }
            userInput = null;
        }
        ServerMessage.close();
        userInputScanner.close();
        clientOut.close();
        socket.close();
    }

    static Socket TryConnection() throws IOException {
        int tryTimes = 0;
        while (tryTimes < 5) {
            try {
                if (tryTimes != 0)
                    PrintTools.println("Trying to re-connect to server...");
                Socket socket = new Socket(serverIP, port);
                PrintTools.println("Connected to server. Server IP: " + socket.getInetAddress().getHostAddress(),
                        PrintTools.ANSI_Green);
                return socket;
            } // catch connect exception
            catch (ConnectException e) {
                PrintTools.println("Server is not running, please start the server first.", PrintTools.ANSI_Red);
                tryTimes++;
            }
        }
        PrintTools.println("Failed to connect to server, please try again later.", PrintTools.ANSI_Red);
        System.exit(-1);
        return null;
    }
}

class ServerReciever implements Runnable {
    Scanner ServerMessage;

    public ServerReciever(Scanner ServerMessage) {
        this.ServerMessage = ServerMessage;
    }

    @Override
    public void run() {
        while (true) {
            if (ServerMessage.hasNext()) {// if client has massage
                String echo = ServerMessage.next().trim();
                System.out.println(echo);
            }
        }

    }
}

class InputReciever implements Callable<String> {
    Scanner userInputScanner;
    // PrintStream clientOut;

    public InputReciever(Scanner userInputScanner) {
        this.userInputScanner = userInputScanner;
        // this.clientOut = clientOut;
    }

    @Override
    public String call() {
        while (true) {
            if (userInputScanner.hasNextLine()) {
                return userInputScanner.nextLine();
            }

        }
    }
}