package fr.jcgay.example.java.map;

import java.util.HashMap;
import java.util.Map;

public class Replace {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("un", 1);
        map.put("deux", 2);

        assert map.replace("un", 1, 5) == true;
        assert map.replace("deux", 3, 5) == false;

        map.forEach((key, value) -> System.out.printf("%s(%d) ", key, value));

        map = new HashMap<>();
        map.put("un", 1);
        map.put("deux", 2);

        map.replaceAll((key, value) -> "un".equals(key) ? value + 1 : value + 2);

        assert map.get("un") == 2;
        assert map.get("deux") == 4;
    }
}
