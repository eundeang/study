package com.eundeang.no_aop;

import java.util.Random;

public class Boy {
    public void makeTaco(){
        System.out.println("배가 고프다"); // 핵심 관심사항 수행 전에 해야될 일
        try {
            System.out.println("타코를 만들어"); // 핵심 관심사항
            if(new Random().nextBoolean()){ // 핵심 관심사항 수행 도중 만약 예외가 발생한다면
                throw new Exception("불났다");
            }
        } catch (Exception e) {
            // 예외 처리가 필요한 경우에 적고 아니면 안적고 중단
            System.out.println("엄마를 부른다");
        } finally {
            // 후처리를 동일하게 해야하는 것은 finally 안쪽, 반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨
            System.out.println("설거지를 한다..");
        }
    }
}
