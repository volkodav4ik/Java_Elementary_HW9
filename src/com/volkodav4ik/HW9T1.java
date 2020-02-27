package com.volkodav4ik;

/*
1.) Есть документ со списком URL:
https://drive.google.com/open?id=1wVBKKxpTKvWwuCzqY1cVXCQZYCsdCXTl
Вывести топ 10 доменов которые встречаются чаще всего. В документе могут встречается пустые и недопустимые строки.
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class HW9T1 {

    private static Map<String, Integer> urlMap = new HashMap<>();
    private static final int TOP_TEN = 10;

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("urls.txt");
        Scanner scanner = new Scanner(fr);
        loadFileToMap(scanner);
        fr.close();
        getTopTen();

    }

    private static void getTopTen() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(urlMap.entrySet());
        list.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        System.out.println("Top 10 The most visited domains:");
        for (int i = 0; i < TOP_TEN; i++) {
            System.out.println(list.get(i).getKey());
        }
    }

    private static void loadFileToMap(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.contains("/")) {
                s = s.substring(0, s.indexOf("/"));
            }
            if (s.startsWith("m.") || s.startsWith("www.")) {
                s = s.substring(s.indexOf(".") + 1);
            }
            if (urlMap.containsKey(s)) {
                urlMap.replace(s, (urlMap.get(s) + 1));
            } else {
                urlMap.put(s, 0);
            }
        }
    }

}
