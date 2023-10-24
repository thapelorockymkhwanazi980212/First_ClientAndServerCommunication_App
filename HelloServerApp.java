
package helloserverapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thapelo Mkhwanazi
 */
public class HelloServerApp {

    public static void main(String[] args) 
    {
        ServerSocket serversocket = null;
        Socket clientSocket = null;
        BufferedReader in;
        String data;
        
        try 
        {
            serversocket = new ServerSocket(64689);  //the server is listening to incoming request from the port number 2020
            System.out.println("Server started: " + serversocket);
            
            //wait for connection and wants to accept connection
            clientSocket = serversocket.accept();
            System.out.println("Connection approved: " + clientSocket + " request..");
            
            //because the connection is approved we read data from the socket 
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            //display data
            data = in.readLine();
            System.out.println("Message recieved from client: " + data);
            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(HelloServerApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally
        {
            
            try {
                System.out.println("Closing...");
                clientSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(HelloServerApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
