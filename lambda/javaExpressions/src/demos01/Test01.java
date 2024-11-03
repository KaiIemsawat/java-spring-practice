package demos01;

//@FunctionalInterface
//interface Cab {
//    void bookCab();
//}
//
//class CapName implements Cab {
//    @Override
//    public void bookCab() {
//        System.out.println("CapName cab is booked...");
//    }
//}
//
//public class Test01 {
//    public static void main(String[] args) {
//        Cab cab = new CapName();
//        cab.bookCab();
//    }
//}

// Convert to expression as below

@FunctionalInterface
interface Cab {
    // For Lambda interface, there can be only one abstract method
    void bookCab();
}

public class Test01 {
    public static void main(String[] args) {
        Cab cab = () -> System.out.println("CapName cab is booked..."); // declaring
        cab.bookCab(); // calling
    }
}