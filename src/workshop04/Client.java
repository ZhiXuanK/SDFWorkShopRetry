package workshop04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Client {
    
    public static void main(String[] args) throws UnknownHostException, IOException{
        
        //args[0] is host:port
        String[] portInfo = args[0].split(":");
        //connect to server
        Socket socket = new Socket(portInfo[0], Integer.parseInt(portInfo[1]));
        System.out.println("Connected to server");

        //get input and output stream
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream (os);
        DataOutputStream dos = new DataOutputStream(bos);

        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        Console cons = System.console();

        //loop for command
        while (true){

            String input = cons.readLine("Key in get-cookie to receive your fortune:  ");
            dos.writeUTF(input);
            dos.flush();

            if (input.equals("close")){
                dos.close();
                bos.close();
                os.close();

                dis.close();
                bis.close();
                is.close();

                System.exit(0);
            }

            if (dis.readUTF().equals("cookie-text")){
                String fortune = dis.readUTF();
                System.out.println(fortune);
            }
            
            
        }

    }


}
