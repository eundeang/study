package com.eundeang.tcp_upgrage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListenThread extends Thread {
    private BufferedReader br;
    public ListenThread(Socket s) {
        try{
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        }catch(IOException e){
            System.out.println("ListenThread Error");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(){
        try {
            while(true){
                String msg = br.readLine();
                System.out.println("받은 메세지 : "+ msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
