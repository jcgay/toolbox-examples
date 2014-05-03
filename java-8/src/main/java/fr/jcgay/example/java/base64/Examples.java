package fr.jcgay.example.java.base64;

import java.util.Base64;

public class Examples {

    public static void main(String[] args) {

        byte[] result = Base64.getEncoder().encode("JC".getBytes());
        System.out.println(new String(result));
    }
}
