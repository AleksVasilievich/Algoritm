package Homework.Homework4;

public class Program {
    public static void main(String[] args) {
        Employee employee1 = new Employee("AAA", 30);
        System.out.println(employee1.getAge() + " " + employee1.getName());
        System.out.println(employee1.hashCode());


        HashMap<String, String> hashMap = new HashMap<>(4);


        String v = hashMap.put("+79", "Сергей");
        v = hashMap.put("+790", "Николай");
        v = hashMap.put("+7", "Юрий");
        v = hashMap.put("+79005551120", "Сергей");
        v = hashMap.put("+79005551123", "Алексей");
        v = hashMap.put("+79005551124", "Александр1");
        v = hashMap.put("+79005551125", "Александр2");
        v = hashMap.put("+79005551126", "Александр3");
        v = hashMap.put("+79005551127", "Александр4");
        v = hashMap.put("+79005551128", "Александр5");


        HashMap.HashMapIterator it = (HashMap.HashMapIterator) hashMap.iterator();
        while (it.hasNext()) {
            it.next();

            Object K = it.next().key;
            Object V = it.next().value;
            System.out.println(K + " - "  + V);

        }
    }
}

