package natujenge.csconcepts.session01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is a test server that waits for a client connection, receives the message
 * and terminates the program after printing the message from a single client
 * ( a delay of 30 seconds before closing connection)
 */
public class TestServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        //a server must listen for client connections on a port
        int serverPort = 6666;

        //start a server socket
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server started on port " + serverPort + ", waiting to accept a connection");

        //wait for a client connection - this method call blocks until a client connection is received
        Socket clientSocket = serverSocket.accept();
        System.out.println("Received a client connection from " + clientSocket.getInetAddress()
                + ", client port " + clientSocket.getPort());

        //read the data received
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = in.readLine();

        System.out.println("Message received: " + message);

        //sleep for 30 seconds - wait for 30 seconds before closing connection
        Thread.sleep(30000);

        //close the connection
        in.close();
        clientSocket.close();
        serverSocket.close();
        System.out.println("closed input stream, client and server sockets");

    }
}
