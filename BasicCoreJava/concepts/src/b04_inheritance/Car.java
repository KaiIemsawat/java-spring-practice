package b04_inheritance;

public class Car extends Vehicle {
  int wheels = 4;
  int door = 4;
  double speed = 60.6;

  String name = "car";

  @Override
  void go(String name) {
    super.go(name);
  }
}
