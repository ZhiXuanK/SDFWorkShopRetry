package workshop04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int portNum;
        //args[0] - server port, args[1] - fortune cookie file
        try {
            portNum = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input port number");
        }

        //create serversocket and establish connection
        ServerSocket server = new ServerSocket(portNum);
        System.out.println("Waiting for connection");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected");
            File cookieFile = new File(args[1]);
            Cookie cookie = new Cookie(cookieFile);
            cookie.open();
            boolean status = true;

            //get command from client
            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            //establish output stream
            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            while (status) {
                String clientInput = dis.readUTF().toLowerCase().trim();

                switch (clientInput){
                    case "get-cookie":
                        dos.writeUTF("cookie-text");
                        dos.flush();

                        dos.writeUTF(cookie.getCookie());
                        dos.flush();
                        break;

                    case "close":
                        dos.close();
                        bos.close();
                        os.close();

                        dis.close();
                        bis.close();
                        is.close();

                        status = false;
                        cookie.close();
                        break;

                }

            }

        }

    }

}
