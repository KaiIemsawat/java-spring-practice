package b06_interface;

public class Fish implements Predator, Pray {

  @Override
  public void flee() {
    System.out.println("Large fish is hunting");
  }

  @Override
  public void hunt() {
    System.out.println("The small fish is swimming away");
  }
}
