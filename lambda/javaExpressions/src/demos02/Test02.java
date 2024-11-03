package demos02;

//interface Animal {
//    void AnimalRequires(String food, String action);
//}
//
//class Lion implements Animal{
//    @Override
//    public void AnimalRequires(String food, String action) {
//        System.out.println("Lions eat " + food + ". Thus, lions " + action);
//    }
//}
//
//public class Test02 {
//    public static void main(String[] args) {
//        Animal animal = new Lion();
//        animal.AnimalRequires("meat", "hunt");
//    }
//}

// Convert to expression as below

interface Animal {
    void AnimalRequires(String food, String action);
}

public class Test02 {
    public static void main(String[] args) {
        Animal animal = (food,  action) -> System.out.println("Lions eat " + food + ". Thus, lions " + action);
        animal.AnimalRequires("meat", "hunt");
    }
}
