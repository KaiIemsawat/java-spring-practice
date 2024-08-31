package b04_inheritance;

public class Main {
  public static void main(String[] args) {
    Car car = new Car();

    car.go(car.name);

    Bicycle bike = new Bicycle();

    bike.stop();

    System.out.println(car.speed);
    System.out.println(bike.speed);

    System.out.println(car.door);
    System.out.println(car.wheels);
    System.out.println(bike.peddles);
    System.out.println(bike.wheels);
  }
}
