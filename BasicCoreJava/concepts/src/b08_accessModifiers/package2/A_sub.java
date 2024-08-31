package b08_accessModifiers.package2;

import b08_accessModifiers.package1.*;

public class A_sub extends A {
  public static void main(String[] args) {
    C c = new C();
    System.out.println(c.defaultMessage); // works because they are in the same package
  }
}
