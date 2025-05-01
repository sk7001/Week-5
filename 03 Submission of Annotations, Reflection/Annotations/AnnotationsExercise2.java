package Annotations;

class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature - Do not use!");
    }

    public void newFeature() {
        System.out.println("New feature - Use this!");
    }
}

public class AnnotationsExercise2 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
