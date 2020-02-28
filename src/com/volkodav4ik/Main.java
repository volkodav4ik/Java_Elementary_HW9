package com.volkodav4ik;

//2*)Реализовать интерфейс MyMap и его имплементацию MyTreeMap - аналог Map<String, String>

public class Main {

    public static void main(String[] args) {

        MyMap myMap = new MyTreeMap();
        System.out.println(myMap.isEmpty());
        System.out.println(myMap.containsKey("one"));
        System.out.println(myMap.size());
        myMap.put("one", "one");
        myMap.put("two", "two");
        myMap.put("three", "three");
        myMap.put("four", "four");
        myMap.put("five", "five");
        myMap.put("six", "six");
        myMap.put("seven", "seven");
        myMap.put("eight", "eight");
        myMap.put("nine", "nine");
        myMap.put("ten", "ten");
        System.out.println(myMap.containsKey("ten"));
        System.out.println(myMap.containsKey("not exist"));
        System.out.println(myMap.size());
        System.out.println(myMap.toString());
        System.out.println(myMap.get("six"));
        System.out.println(myMap.containsValue("eight"));
        System.out.println(myMap.containsValue("not exist"));
        myMap.put("ten", "10");
        myMap.put("six","6");
        System.out.println(myMap.toString());

    }
}
