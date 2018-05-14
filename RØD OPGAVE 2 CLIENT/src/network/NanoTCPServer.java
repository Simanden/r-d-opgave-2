package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class NanoTCPServer {

    public static void main(String[] args) {


        try {

            ServerSocket serverSocket = new ServerSocket(7777);
            Socket socket = serverSocket.accept(); // blokerer

            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            System.out.println("");
            while (true) {
                    if (bufferedReader1.ready()) {
                        System.out.println(bufferedReader1.readLine());
                    }
                if (bufferedReader2.ready())
                {
                    printWriter.println(bufferedReader2.readLine());
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
