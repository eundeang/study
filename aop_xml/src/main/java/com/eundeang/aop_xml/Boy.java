package com.eundeang.aop_xml;

import java.util.Random;

public class Boy {
    public void makeTaco() throws Exception {
        System.out.println("타코를 만들어"); // 핵심 관심사항
        if (new Random().nextBoolean()) { // 핵심 관심사항 수행 도중 만약 예외가 발생한다면
            throw new Exception("불났다");
        }

    }
}
