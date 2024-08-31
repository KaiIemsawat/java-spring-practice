package b08_accessModifiers.package3;

import b08_accessModifiers.package2.C;

public class C_sub extends C {
  public static void main(String[] args) {
    //      Can access cSub.protectedMessage because of 'protected'
    C_sub cSub = new C_sub();
    System.out.println(cSub.protectedMessage);
  }
}
