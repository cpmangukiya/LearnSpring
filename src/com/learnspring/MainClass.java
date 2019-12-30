package com.learnspring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class MainClass {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        Student studentSetter = (Student) factory.getBean("studentBean");
        studentSetter.displayInfo();

        Student studentConst = (Student) factory.getBean("studentBeanConst");
        studentConst.displayInfo();

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression hello_spEL = expressionParser.parseExpression("'Welcome SPEL'.concat('!')");
        String message = (String) hello_spEL.getValue();
        System.out.println("Hello SpEL output:"+message);

        Expression exp = expressionParser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        for(int i=0;i<bytes.length;i++){
            System.out.print(bytes[i]+" ");
        }
        System.out.println();

        Expression exp2 = expressionParser.parseExpression("new String('hello world').toUpperCase()");
        String message2 = exp2.getValue(String.class);
        System.out.println(message2);
    }
}