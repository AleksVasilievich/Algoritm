package Homework.Homework4;

public class Program {
    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>(4);

        String v = hashMap.put("+79746354676", "Сергей");
        v = hashMap.put("+79045354534", "Николай");
        v = hashMap.put("+73462875439", "Юрий");
        v = hashMap.put("+79005551120", "Сергей");
        v = hashMap.put("+79005551123", "Алексей");
        v = hashMap.put("+79005551124", "Александр1");
        v = hashMap.put("+79005551125", "Александр2");
        v = hashMap.put("+79005551126", "Александр3");
        v = hashMap.put("+79005551127", "Александр4");
        v = hashMap.put("+79005551128", "Александр5");

        for (HashMap.Entity entity : hashMap) {
            System.out.println(entity.getKey() + " - " + entity.getValue());
        }

    }
}

