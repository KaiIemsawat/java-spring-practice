package demos03Predicates;

import java.util.function.Predicate;

// Predicate -> One parameter, return boolean.
// Use only if having conditional check.
public class Demo01 {
    public static void main(String[] args) {

        // Example : 1
        Predicate<Integer> p1 = i -> (i > 10);
        System.out.println(p1.test(20));
        System.out.println(p1.test(5));
        System.out.println();

        // Example : 2
        Predicate<String> p2 = s -> (s.length() > 4);
        System.out.println(p2.test("Zukkii"));
        System.out.println(p2.test("Kin"));
        System.out.println();

        // Example : 3
        String names[] = {"Zukkii", "Titann", "Kinkin", "Kai"};
        for (String n : names) {
            Predicate<String> p3 = s -> (s.length() > 4 && s.toLowerCase().contains("k"));
            System.out.println(p3.test(n));
        }
    }
}
