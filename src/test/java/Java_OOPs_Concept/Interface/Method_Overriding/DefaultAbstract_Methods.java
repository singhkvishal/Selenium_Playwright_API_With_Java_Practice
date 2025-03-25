package Java_OOPs_Concept.Interface.Method_Overriding;


  class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}
  interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}
  interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}
public class DefaultAbstract_Methods extends Horse implements Flyer, Mythical {
    public static void main(String... args) {
        DefaultAbstract_Methods myApp = new DefaultAbstract_Methods();
        System.out.println(myApp.identifyMyself());
    }
}