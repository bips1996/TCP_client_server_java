import java.net.*;
import java.io.*;
/**
 * This example illustrates the basic syntax for stream-mode
 * socket.
 * @author M. L. Liu
 */
public class Example4ConnectionAcceptor {

// An application that accepts a connection and receives a message 
//  using stream-mode socket.
// Two command line arguments are expected, in order: 
//    <port number for the the Server socket used in this process>
//    <message, a string, to send>

   public static void main(String[] args) {
      if (args.length != 2)
         System.out.println
            ("This program requires two command line arguments");
      else {
         try {
  		      int portNo = Integer.parseInt(args[0]);
            String message = args[1];
            // instantiates a socket for accepting connection  	
   	      ServerSocket connectionSocket = new ServerSocket(portNo);
/**/        System.out.println("\nReady for accepting a TCP socket connection ....\n");  
            // wait to accept a connecion request, at which
            //  time a data socket is created                  
            Socket dataSocket = connectionSocket.accept();
/**/        InputStream istream = dataSocket.getInputStream() ;
            DataInputStream dInputStream = new DataInputStream(istream);
            int num1 = dInputStream.readInt() ;
            int num2 = dInputStream.readInt() ;
            int res  = num1 + num2 ;
            OutputStream oStream = dataSocket.getOutputStream() ;
            DataOutputStream doStream= new DataOutputStream(oStream) ;
            doStream.writeInt(res);
             
            dataSocket.close( );
/**/        System.out.println("data socket closed\n");
            connectionSocket.close( );
/**/        System.out.println("connection socket closed\n"); 
         } // end try
	      catch (Exception ex) {
            ex.printStackTrace( );
	      } //end catch
      } // end else
   } // end main
} // end class