class Animal {
   public void makeSound() {
       System.out.println("Some animal sound");
   }
}
class Dog extends Animal {
   @Override
   public void makeSound() {
       System.out.println("Bark");
   }
}
public class AnnotationsExerciseOverride {
   public static void main(String[] args) {
       Dog dog = new Dog();
       dog.makeSound();
   }
}
