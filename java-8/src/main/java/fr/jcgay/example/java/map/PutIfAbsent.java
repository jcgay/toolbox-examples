package fr.jcgay.example.java.map;

import java.util.HashMap;
import java.util.Map;

public class PutIfAbsent {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        assert map.putIfAbsent("key", null) == null;
        assert map.get("key") == null;

        assert map.putIfAbsent("key", "value") == null;
        assert map.get("key").equals("value");

        assert map.putIfAbsent("key", "new-value").equals("value");
        assert map.get("key").equals("value");
    }
}
