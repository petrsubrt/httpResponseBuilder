package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream());


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s;
            while ((s = in.readLine()) != null) {
                System.out.println(s);
                if (s.isEmpty()) {
                    break;
                }
            }

            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);


            outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
            outputStream.write("\r\n".getBytes());
            outputStream.write("<b>Hello World</b>".getBytes());
            outputStream.write("\r\n\r\n".getBytes());
            writer.flush();

        }
    }
}
