package com.eundeang.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999); // 데이터 송수신 용도가 아닌 연결 대비 소켓임
        System.out.println("서버 연결 오기를 기다리는 중...");
        Socket socket = serverSocket.accept(); // 이게 데이터 송수신을 위한 객체, 여기서 클라의 요청을 기다림
        System.out.println("연결 들어옴! 클라의 소켓 확보"); //데이터 송수신이 가능해지는 시점

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("서버는 계속 들어주기만 해요" + bufferedReader.readLine());
            System.out.println("대답 메세지를 작성해주세요>> ");
            String msg = scanner.nextLine();
            bufferedWriter.write(msg+"\n");
            bufferedWriter.flush();

        }
    }
}
