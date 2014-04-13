package fr.jcgay.example.java.map;

import java.util.HashMap;
import java.util.Map;

public class GetOrDefault {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("un", 1);
        map.put("deux", 2);
        map.put("trois", 3);

        assert map.getOrDefault("un", -1) == 1;
        assert map.getOrDefault("six", -1) == -1;
    }
}
