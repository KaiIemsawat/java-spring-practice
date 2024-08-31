package b07_static;

public class Friend {
  String name;
  static int staticNumberOfFriend;
  int nonStaticNumberOfFriend;

  Friend(String name) {
    this.name = name;
    staticNumberOfFriend++;
    nonStaticNumberOfFriend++;
  }

  static void displayFriends() {
    System.out.println("You have " + staticNumberOfFriend + " friends");
    //    System.out.println("You have " + nonStaticNumberOfFriend + " friends"); // <-- will show
    // error since this is static method and nonStaticNumberOfFriend is non-static

  }
}
