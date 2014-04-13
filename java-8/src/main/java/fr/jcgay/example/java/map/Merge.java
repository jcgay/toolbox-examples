package fr.jcgay.example.java.map;

import java.util.HashMap;
import java.util.Map;

public class Merge {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "un");
        map.put(2, "deux");

        assert map.merge(1, " exemple", String::concat).equals("un exemple");
        assert map.merge(2, "exemples", (key, value) -> null) == null;

        map.forEach((key, value) -> System.out.printf("%d(%s) ", key, value));
    }
}
