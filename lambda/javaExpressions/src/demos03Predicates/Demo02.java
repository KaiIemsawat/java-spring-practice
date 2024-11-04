package demos03Predicates;

import java.util.function.Predicate;

class Employee {
    String name;
    int salary;
    int experience;

    Employee(String name, int salary, int experience) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }
}


public class Demo02 {
    public static void main(String[] args) {
        Employee emp = new Employee("Zukkii", 365, 7);
        Predicate<Employee> pr01 = e -> (e.experience > 6 && e.salary >= 200);
        System.out.println(pr01.test(emp));
    }

}
