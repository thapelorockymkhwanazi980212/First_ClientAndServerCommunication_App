
package helloclientapp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thapelo Mkhwanazi
 */
public class HelloClientApp
{

    public static void main(String[] args)
    {
        
        InetAddress address = null;
        Socket clientSocket = null;
        String serveIpAddress;
        PrintWriter out;
        
        try 
        {
            serveIpAddress = "127.0.0.1";
            address = InetAddress.getByName(serveIpAddress); // this is the address of the machine I want to write to
             //used to write data to the server
            
            //a Socket is used to initiate a connection to a server, the server will recieve the socket and communicate 
            clientSocket = new Socket(address, 64689);
            System.out.println("Socket: " + clientSocket);
            
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);
            
            //here am sending data
            out.println("Hello");
            
        } 
        
        catch (UnknownHostException ex) {
            Logger.getLogger(HelloClientApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelloClientApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally
        {
            try
            {
                System.out.println("Closing the communication socket....");
                clientSocket.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(HelloClientApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
