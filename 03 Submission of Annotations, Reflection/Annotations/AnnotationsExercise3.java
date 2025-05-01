package Annotations;

import java.util.ArrayList;

public class AnnotationsExercise3 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(123);

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
