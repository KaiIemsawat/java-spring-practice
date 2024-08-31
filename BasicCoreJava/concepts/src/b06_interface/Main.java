package b06_interface;

public class Main {
  public static void main(String[] args) {

    Rabbit rabbit = new Rabbit();
    Hawk hawk = new Hawk();
    Fish fish = new Fish();

    hawk.hunt();
    rabbit.flee();
    System.out.println("=======");
    fish.hunt();
    fish.flee();
  }
}
