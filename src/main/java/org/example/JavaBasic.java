package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaBasic {
    public static void main(String[] args) {

        //Variabile si dataType
        int nr = 10;
        String caractere = "a";
        char caracter = 's';
        double numar = 12.32;
        boolean adv = true;

        //Arrays
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(arr2.length);
        System.out.println(Arrays.toString(arr2)); //apar toate

        //for loop
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " "); // parcurgere a arr2 crescatoare
        }

        for (int i = arr2.length - 1; i >= 0; i--) {
            System.out.print(arr2[i] + " "); // parcurgere a arr2 descrescatoare
        }

        String[] name = {"John", "kk", "aa", "bb", "cc", "dd"};
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i] + " "); // parcurgere de sir de caractere
        }

        for (String i : name) {
            System.out.println(i + " "); //*length
        }
        for (Integer i : arr) {
            System.out.println(i + " ");
        }

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] % 2 == 0) {
                System.out.print(arr2[i] + " ");
            }
        }


        int sum = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum += arr2[i];
            System.out.println(sum + " ");
        }

        //ArrayList

        System.out.println("ArrayList ");
        ArrayList list = new ArrayList();
        list.add("John");
        list.add(12);

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("aa");
        list2.add("32");

        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(1);
        list3.add(2);

        System.out.println(" List " + list.size());
        System.out.println(" List 2 " + list2.get(1));
        System.out.println(" List 3 " + list3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(" List " + list.get(i) + " ");
        }
        for (String val : list2) {
            System.out.println(" List 2 " + val + " ");
        }
        // items present in ArrayList
        System.out.println(" Items present in ArrayList ");
        System.out.println(list.contains(12 + "John"));
        System.out.println(list2.contains("aa"));
        System.out.println(list2.contains("aa" + "32"));

        int[] arr3 = {1, 2, 3, 4, 5};
        List<Integer> convert = Arrays.stream(arr3).boxed().toList();
        System.out.println(Arrays.toString(arr3));
        System.out.println(arr3.length);

        String[] arr4 = {"aa", "bb", "cc", "dd"};
        List<String> convertS = Arrays.asList(arr4);
        System.out.println(convertS.contains("bb") + " " + convertS.contains("cc"));


        //String is an object
        System.out.println(" String is an object ");
        String s = "Sir de caractere ";
        String s1 = "Sir de caractere "; // create a single object
        System.out.println(s1 + " ");


        //new , always it s a new object
        String s2 = new String("welcome ");
        String s3 = new String("welcome ");

        Integer[] s5 = {1, 2, 3, 4, 5};
        String s4 = "Sir de caractere ";
        String[] split = s4.split("de");
        System.out.println(split[0] + " " + split[1]);
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i] + " ");
        }

        System.out.println(split[1].trim());

        for (int i = s4.length() - 1; i >= 0; i--) {
            System.out.print(s4.charAt(i));
            System.out.println(s4.charAt(i));
        }

    }
}
