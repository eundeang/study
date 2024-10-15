package com.eundeang.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        // 데이터 내보내는게 목적이라 특정한 포트를 지정하지 않음
        // 어느 포트로 가는게 별로 중요하지 않아서, 딱히 지정안함
        DatagramSocket sendSocket = new DatagramSocket();
        String msg = "";
        byte[] byteMsg = msg.getBytes(StandardCharsets.UTF_8);
        // 바이트로 쪼개서 보내야 하는 이유
        // i/O 처럼 꺠짐
        DatagramPacket sendPacket = new DatagramPacket(byteMsg,byteMsg.length,new InetSocketAddress("59.27.84.200",8888));
        System.out.println("데이터를 통신합니다.");
        sendSocket.send(sendPacket);
        System.out.println("데이터 통신 완료");
    }
}
