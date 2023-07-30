package AlgorithmSeminar4_1;

import AlgorithmSeminar4.Employee;
import AlgorithmSeminar4.HashMap;

public class Program {
    public static void main(String[] args) {
        AlgorithmSeminar4.Employee employee1 = new Employee("AAA", 30);
        System.out.println(employee1.getAge() + " " + employee1.getName());
        System.out.println(employee1.hashCode());

        AlgorithmSeminar4.HashMap<String, String> hashMap = new HashMap<>(4);
        System.out.println();
    }
}
