package fr.jcgay.example.java.annotation;

import fr.jcgay.example.java.Description;
import fr.jcgay.example.java.Descriptions;

@Description("toto")
@Description("tata")
public class Repeat {

    public static void main(String[] args) {

        Description[] byType = Repeat.class.getAnnotationsByType(Description.class);
        assert byType.length == 2;

        Description withoutType = Repeat.class.getAnnotation(Description.class);
        assert withoutType == null;

        Descriptions byContainer = Repeat.class.getAnnotation(Descriptions.class);
        assert byContainer != null;
        assert byContainer.value().length == 2;
    }
}
