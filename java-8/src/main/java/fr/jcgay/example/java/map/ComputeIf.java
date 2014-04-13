package fr.jcgay.example.java.map;

import java.util.HashMap;
import java.util.Map;

public class ComputeIf {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("un", 1);
        map.put("deux", 2);
        map.put("trois", 3);

        assert map.compute("un", (key, value) -> null) == null;
        assert map.compute("deux", (key, value) -> value == null ? null : value + 2) == 4;

        map.forEach((key, value) -> System.out.printf("%s(%d) ", key, value));
    }

    public static void ifAbsent() {

        Map<String, Integer> map = new HashMap<>();
        map.put("un", 1);
        map.put("deux", 2);
        map.put("trois", 3);

        assert map.computeIfAbsent("un", key -> null) == 1;
        assert map.computeIfAbsent("quatre", key -> 4) == 4;

        map.forEach((key, value) -> System.out.printf("%s(%d) ", key, value));
    }

    public static void ifPresent() {

        Map<String, Integer> map = new HashMap<>();
        map.put("un", 1);
        map.put("deux", 2);
        map.put("trois", 3);
        map.put("quatre", null);

        assert map.computeIfPresent("trois", (key, value) -> value + 5) == 8;
        assert map.computeIfPresent("un", (key, value) -> null) == null;
        assert map.computeIfPresent("quatre", (key, value) -> value + 5) == null;

        map.forEach((key, value) -> System.out.printf("%s(%d) ", key, value));
    }
}
