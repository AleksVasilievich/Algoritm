package AlgorithmSeminar4;

import java.util.Objects;

public class Program {
    public static void main(String[] args) {
        Employee employee1 = new Employee("AAA", 30);
        System.out.println(employee1.getAge() + " " + employee1.getName());
        System.out.println(employee1.hashCode());

        HashMap<String, String> hashMap = new HashMap<>(4);

        String v = hashMap.put("+7903", "Сергей");
        v = hashMap.put("+7904", "Николай");
        v = hashMap.put("+7904", "Юрий");

        String searchRes = hashMap.get("+7903");
        System.out.println(searchRes);
    }
}
