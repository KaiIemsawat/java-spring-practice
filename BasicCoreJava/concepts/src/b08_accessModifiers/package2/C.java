package b08_accessModifiers.package2;

import b08_accessModifiers.package1.*;

public class C {
  String defaultMessage = "This is the default";
  public String publicMessage = "This is the public message";
  protected String protectedMessage = "This is protected message";
  private static String privateMessage = "This is private message";

  public static void main(String[] args) {
    System.out.println(privateMessage); // Only work on this class
  }
}
