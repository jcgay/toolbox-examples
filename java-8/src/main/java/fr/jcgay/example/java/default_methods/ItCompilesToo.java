package fr.jcgay.example.java.default_methods;

public class ItCompilesToo implements A,B {

    @Override
    public void printSomething() {
        B.super.printSomething();
    }
}
