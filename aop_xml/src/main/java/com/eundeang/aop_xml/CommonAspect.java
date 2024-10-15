package com.eundeang.aop_xml;

public class CommonAspect {
    public void bbfore(){
        System.out.println("배가 고프다"); // 핵심 관심사항 수행 전에 해야될 일);
    }


    public void aafterThrowing(){
        System.out.println("엄마를 부른다");
    }
    public void aafter(){
        System.out.println("설거지를 한다..");
    }
}
