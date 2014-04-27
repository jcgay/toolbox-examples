package fr.jcgay.example.java.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Examples {

    public static void main(String[] args) throws ScriptException {

        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        engine.eval("function sum(a, b) { return a + b; }");
    
        assert (int) engine.eval("sum(1, 2);") == 3;
    }
}
