package fr.jcgay.example.java.map;

import java.util.HashMap;
import java.util.Map;

public class ForEach {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("un", 1);
        map.put("deux", 2);
        map.put("trois", 3);

        map.forEach((key, value) -> System.out.printf("%s(%d) ", key, value));
    }
}
