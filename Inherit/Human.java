
public class Human extends Abstract {

    public void walk() {
        System.out.println("Human is Walking");
    }

    public static void main(String[] args) {
        Human human = new Human();
        human.breath();
        human.eat();
        human.walk();
    }
}
