import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8008);
            //Create a new socket. Here, 8008 is port.
            while (true) {
                Socket incoming = s.accept();
                //Accept method returns the socket and
                //establish a connection between server and client.
                
                BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
                //BufferedReader class is used to read the text from a character-based input stream.
                //An InputStreamReader is a bridge from byte streams to character streams:
                //It reads bytes and decodes them into characters using a specified charset.
                //getInputStream() returns the InputStream attached with this socket.
                
                PrintWriter out = new PrintWriter(new OutputStreamWriter(incoming.getOutputStream()));
                //PrintWriter class is used to print the formatted representation of objects to the text-output stream.
                //OutputStreamWriter is a class which is used to convert character stream to byte stream,
                //the characters are encoded into byte using a specified charset.
                //getOutputStream() returns the OutputStream attached with this socket.
                
                out.println("Hello! BITS Dubai");
                out.println("Enter BYE to exit.");
                out.flush(); // It is used to flushes the stream.

                while (true) {
                    String str = in.readLine(); //
                    out.println("Echo: " + str);
                    out.flush();
                    if (str.trim().equals("BYE"))
                        break;
                }
                incoming.close();//Closes this socket
            }
        } catch (Exception e) {}
    }
}