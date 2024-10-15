package com.eundeang.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket receiveSocket = new DatagramSocket(9999);
        System.out.println("UDP Server started");
        while (true) {
            //packet은 저쪽에서 던지는 데이터 꾸러미(상자.) receivePacket은 무안택배함 정도로 생각하면 댐
            DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
            System.out.println("데이터 수신 대기중");
            receiveSocket.receive(receivePacket); // 기다림
            String receiveMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("메세지 결과: " + receiveMsg);
            System.out.println("메세지 수신 완료");

        }
    }
}
