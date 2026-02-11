package org.example;

public class MethodsJavaBasic extends Parent {
    public static void main(String[] args) {
        MethodsJavaBasic a = new MethodsJavaBasic();
        MethodsJavaBasic b = new MethodsJavaBasic();
        MethodsJavaBasic c = new MethodsJavaBasic();
        Parent p = new Parent();

        a.getData();
        getData1("buna");

        String name = a.getData2();
        System.out.println(name);


        p.nameP = "parent";
        p.getName();
        p.Parent1("Bogdan");
        a.nameP = " getNameP";
        System.out.println(a.getNameP());

        String c1 = getData3();
        String data3 = getData3();
        getData3();

    }

    public static void getData1(String data) {
        System.out.println("getData1" + " " + data);
    }

    public static String getData3() {
        System.out.println("getData3" + " ");
        return "getData3 ";
    }

    public String getData2() {
        System.out.println("getData2" + " ");
        return "GetData2";
    }

    public void getData() {
        System.out.println("getData");
    }
}


