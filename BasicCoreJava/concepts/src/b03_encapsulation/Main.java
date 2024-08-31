package b03_encapsulation;

public class Main {
  public static void main(String[] args) {
    Car car = new Car("Subaru", "Impreza", 2013);

    System.out.println(car.getMake());
    System.out.println(car.getModel());
    System.out.println(car.getYear());

    car.setModel("Forester");
    car.setYear(2023);

    System.out.println(car.getModel());
    System.out.println(car.getYear());
  }
}
