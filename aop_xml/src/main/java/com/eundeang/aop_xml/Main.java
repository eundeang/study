package com.eundeang.aop_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new FileSystemXmlApplicationContext("aop_xml/beans.xml");
        Boy dawon = (Boy) context.getBean("dawon");
        dawon.makeTaco();
    }
}
