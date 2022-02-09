package natujenge.csconcepts.session01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class TestClient {

    public static void main(String[] args) throws IOException {

        //initialize server ip and port - we can use 127.0.0.1 or localhost
        String serverIPAddress = "127.0.0.1";
        int serverPort = 6666;

        String message = "Hello";

        //establish a connection to the server
        Socket clientSocket = new Socket(serverIPAddress, serverPort);

        System.out.println("Established a connection to server " + serverIPAddress + " and port " + serverPort);
        System.out.println("Client IP " + clientSocket.getLocalAddress() + " and port " + clientSocket.getLocalPort());

        //about to send the data (message)
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(message);
        System.out.println("Sent message: " + message);

        //no need to close the connection - our TestServer will do it
    }
}
