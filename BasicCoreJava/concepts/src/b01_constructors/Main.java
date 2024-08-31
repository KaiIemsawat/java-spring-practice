package b01_constructors;

public class Main {

  public static void main(String[] args) {
    Human human1 = new Human("Zukkii", 6, 17);
    Human human2 = new Human("Titann", 5, 20);

    human2.eat();
    human1.drink();

    System.out.println(human1.name);
    System.out.println(human2.name);
  }
}
