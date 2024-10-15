package multi_chatting;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MultiChattingClient {
    // try-catch를 안쓴이유는?
    // 서버에 문제가 일어났으면 바로 프로그램 종료하면 되기 떄문
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("59.27.84.200", 9999);
        System.out.println("서버와 연결 성공");

        new Listen(socket).start();
        new Speak(socket).start();

    }
    static class Listen extends Thread {
        BufferedReader br;
        Listen(Socket socket) throws IOException {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String receiveMsg = br.readLine();
                    System.out.println(receiveMsg);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static class Speak extends Thread {
        BufferedWriter bw;
        Scanner sc;

        Speak(Socket socket) throws IOException {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            sc = new Scanner(System.in);
            System.out.println("당신의 닉네임을 입력하세요");
            String nickName = sc.nextLine();
            //write를 할 때에는 readline할 수 있게 개행문자 추가해주고, flush 하기
            bw.write(nickName+"\n");
            bw.flush();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("me >> ");
                    String sendMsg = sc.nextLine();
                    bw.write(sendMsg + "\n");
                    bw.flush();
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }

    }
}
