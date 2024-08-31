package b05_polymorphism;

public class Main {
  public static void main(String[] args) {

    Car car = new Car();
    Bicycle bicycle = new Bicycle();
    Boat boat = new Boat();

    Vehicle[] racers = {car, bicycle, boat};

    car.go();
    bicycle.go();
    boat.go();

    System.out.println("============");

    for (Vehicle v : racers) {
      v.go();
    }
  }
}
