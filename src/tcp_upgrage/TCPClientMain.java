package tcp_upgrage;

import java.io.IOException;
import java.net.Socket;

public class TCPClientMain {
    public static void main(String[] args) throws IOException {
        Thread t = new ListenThread(new Socket());
        t.start();
        System.out.println("서버에게 연결을 시도할 거에요");
        Socket socket = new Socket("127.0.0.1",9999); // 요청을 보냄
        System.out.println("서버가 요청을 받아줬습니당~");
        Thread listen = new ListenThread(socket);
        Thread speak = new SpeakThread(socket);
        listen.start();
        speak.start();
    }
}
