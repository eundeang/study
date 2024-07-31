package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("서버에게 연결을 시도할 거에요");
        Socket socket = new Socket("127.0.0.1",9999); // 요청을 보냄
        System.out.println("서버가 요청을 받아줬습니당~");

        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("보낼 메세지 입력 >>");
            String msg = sc.nextLine(); // 키보드로 입력받은 메세지를 보내기
            br.write(msg+"\n");
            br.flush();
            System.out.print("대답 메세지가 도착했어요>> " + bufferedReader.readLine());
        }
        // 소켓이나 버퍼드라이터 close해줘야 함
    }
}
