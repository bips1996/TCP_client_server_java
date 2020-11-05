//**************************************************************
// See BetterExample4ConnectionRequestor.java for an improved
// version of this class.  This class does not allow a timeout
// on connection.  The better version does.
//**************************************************************

import java.net.*;
import java.io.*;

/**
 * This example illustrates the basic syntax for stream-mode
 * socket.
 * @author M. L. Liu
 */
public class Example4ConnectionRequestor {

// An application that requests a connection and
//  sends a message using stream-mode socket.
// Two command line arguments are expected: 
//
//    <host name of the connection accceptor>
//    <port number of the connection accceptor>

   public static void main(String[] args) {
      if (args.length != 4)
         System.out.println
            ("This program requires four command line arguments");
      else {
         try {
  		      InetAddress acceptorHost = InetAddress.getByName(args[0]);
  		      int acceptorPort = Integer.parseInt(args[1]);
            int num1 = Integer.parseInt(args[2]) ;
            int num2 = Integer.parseInt(args[3]) ;
            // instantiates a data socket
   	      Socket mySocket = new Socket(acceptorHost, acceptorPort); 
/**/        System.out.println("Connection request granted"); 
            // get an input stream for reading from the data socket
Thread.sleep(3000);
            OutputStream socketOutput = mySocket.getOutputStream();
            DataOutputStream doutputStream = new DataOutputStream(socketOutput) ;
            doutputStream.writeInt(num1) ;
            doutputStream.writeInt(num2) ;
/**/        System.out.println("setting up  data stream to read a msg ... ");
            InputStream inStream = mySocket.getInputStream();
            // create a BufferedReader object for text line input
            DataInputStream dinputStream = new DataInputStream(inStream);
            int res ;
            res = dinputStream.readInt() ;

/**/        System.out.println("Result = "+res);
            mySocket.close( );
/**/        System.out.println("data socket closed");
         } // end try
	      catch (Exception ex) {
            ex.printStackTrace( );
	      } //end catch
      } // end else
   } // end main
} // end class

