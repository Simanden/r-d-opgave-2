package network;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class NanoTCPClient {



    public static void main(String[] args) {
        try {
           // String ip = "10.111.176.120";
            String ip = InetAddress.getLocalHost().getHostAddress();
            Socket socket = new Socket(ip, 7777);
            //InputStream inputStream = socket.getInputStream();

            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            while (true) {

                    if (bufferedReader1.ready()) {
                        System.out.println(bufferedReader1.readLine());
                    }
                if (bufferedReader2.ready())
                {
                    pw.println(bufferedReader2.readLine());
                }
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
