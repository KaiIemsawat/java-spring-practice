package b06_interface;

public class Rabbit implements Pray {

  @Override
  public void flee() {
    System.out.println("The rabbit is fleeing");
  }
}
