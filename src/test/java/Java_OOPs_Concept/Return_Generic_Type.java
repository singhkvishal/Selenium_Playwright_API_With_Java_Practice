package Java_OOPs_Concept;

import java.util.HashMap;
import java.util.Map;

public class Return_Generic_Type {
    public static class Animal {
        private Map<String, Return_Generic_Type.Animal> friends = new HashMap<>();

        public void addFriend(String name, Return_Generic_Type.Animal animal) {
            friends.put(name, animal);
        }

        public <T> T callFriend(String name) {
            return (T) friends.get(name);//Casting to T not needed in this case but its a good practice to do
        }
    }

    public static class Dog extends Return_Generic_Type.Animal {
        public void bark() {
            System.out.println("i am dog");
        }
    }

    public static class Duck extends Return_Generic_Type.Animal {
        public void quack() {
            System.out.println("i am duck");
        }
    }

    public static void main(String[] args) {
        Return_Generic_Type.Animal animals = new Return_Generic_Type.Animal();
        animals.addFriend("dog", new Return_Generic_Type.Dog());
        animals.addFriend("duck", new Return_Generic_Type.Duck());

        Return_Generic_Type.Dog dog = animals.callFriend("dog");
        dog.bark();

        Return_Generic_Type.Duck duck = animals.callFriend("duck");
        duck.quack();

    }
}
