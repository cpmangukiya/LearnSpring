package com.learnspring;

public class Student {
    private String name;

    public Student () {
        // do nothing
    }

    public Student (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Hello:: " + name);
    }
}
