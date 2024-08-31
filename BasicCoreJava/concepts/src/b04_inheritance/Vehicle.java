package b04_inheritance;

public class Vehicle {

  double speed;
  String name;

  void go(String name) {
    System.out.println("This " + name + " is moving");
  }

  void stop() {
    System.out.println("This vehicle is stopped");
  }
}
