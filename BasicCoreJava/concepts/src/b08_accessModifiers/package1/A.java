package b08_accessModifiers.package1;

import b08_accessModifiers.package2.*;

public class A {
  public static void main(String[] args) {

    C c = new C();
    //    System.out.println(c.defaultMessage); // <-- Would not work, default will work only in the
    // same class or package

    System.out.println(c.publicMessage); // <-- Works because it's public
  }
}

/*
 *   MODIFIER          Class   Package   Subclass    Global
 *   public              Y       Y         Y           Y
 *   protected           Y       Y         Y           N
 *   Default (No modify) Y       Y         N           N
 *   private             Y       N         N           N
 */
