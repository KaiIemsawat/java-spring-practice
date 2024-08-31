package b07_static;

public class Main {
  public static void main(String[] args) {

    /*
     * static =  modifier. A single copy of a variable/method is created and shared.
     *           The clas "owns" the static member
     */

    Friend friend1 = new Friend("Zukkii");
    Friend friend2 = new Friend("Titann");

    System.out.println(Friend.staticNumberOfFriend); // 2
    System.out.println(friend1.nonStaticNumberOfFriend); // 1
    System.out.println(friend2.nonStaticNumberOfFriend); // 1

    System.out.println("==========");

    Friend.displayFriends();
  }
}
