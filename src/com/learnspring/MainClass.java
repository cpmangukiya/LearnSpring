package com.learnspring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainClass {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        Student studentSetter = (Student) factory.getBean("studentBean");
        studentSetter.displayInfo();

        Student studentConst = (Student) factory.getBean("studentBeanConst");
        studentConst.displayInfo();
    }
}
