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
        v = hashMap.put("+79005551123", "Сергей");
        v = hashMap.put("+79005551123", "Алексей");
        v = hashMap.put("+79005551124", "Александр1");
        v = hashMap.put("+79005551125", "Александр2");
        v = hashMap.put("+79005551126", "Александр3");
        v = hashMap.put("+79005551127", "Александр4");
        v = hashMap.put("+79005551128", "Александр5");

        String searchRes = hashMap.get("+7903");
        //v = hashMap.remove("+7904");
        System.out.println(searchRes);

        v = hashMap.remove("+79005551127");
        System.out.println(v);

//        for (Object e: hashMap) {
//
//        }
    }
}
