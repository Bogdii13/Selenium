package org.example;

public class Parent {
    String nameP;
    int age;


    public void Parent1(String name) {
        System.out.println("Parent1 " + name);
    }

    public void getName() {
        System.out.println("Parent1 " + nameP);
    }

    public String getNameP() {
        return "Parent1 " + nameP;
    }
}
