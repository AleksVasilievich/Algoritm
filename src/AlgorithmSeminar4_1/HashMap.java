package AlgorithmSeminar4_1;

/**
 * Хеш Таблица
 * Создадим свою структуру данных
 * @param <K>  ключ
 * @param <V> значние
 */

public class HashMap<K, V> {

    private static final int INIT_BUCKET_COUNT = 16; // Начальная размерность массива Backet[]
    private static final double LOAD_FACTOR = 0.5;

    private int size;

    public int getSize() {
        return size;
    }


    private Bucket[] buckets; // Наша Структура данных HashMap дудет содержать массив backets (связных списков)

    /**
     *  Структура данных содержащая два значения (Объединяет)
     *  Теперь наш Узел связного списка Node может содержать два значения типа Entity
     */
    class Entity{
        K key;
        V value;
    }
    /**
     * Внутри нашей структуры данных будет лежать массив состоящий из связных списков
     */
    class Bucket<K, V> {

        Node head; // Ссылка на первый элемент связного списка

        /**
         * Узел связного списка
         */
        class Node{
            Node next;  //Ссылка на следующий элемент
            Entity value;  // Значение узла связного списка - состовное - состоящее из ключа и какогото значения
        }

        public V add(Entity entity){
            Node node = Node();//Подготавливаем новый узел Node каторый хранит соответствующее значение
            node.value = entity;


        }
    }

    /**
     * Метод позволяющий вычислить (вернуть) индекс нашего массива
     * На вход принимает ключ (K key) и берём от него хеш код(key,heshCode()) по модулю
     * и отнего берём остаток от деления на расмер нашего массива % buckets.length
      */

    private int calculateBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    /**
     * Метод добовляющий новый элемент в нашу таблицу HashMap
     * На вход передодим ключ значение , затрём и вернём старое значение
     * если ключ нового элемента будет совпадать, если не совпадёт то вернём null
     * Для добавления необходим индекс массива Bucket[] каторый получим
     * из метода calculateBucketIndex(K key)
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value){
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];// Получаем доступ к элементу нашего массива по индексу
        if (bucket == null){
            bucket = new Bucket();// Инициализируем новый объект связного списка
            buckets[index] = bucket;//Поместим ссылку на на новый объект в переменную нашей ячейки
        }
        /**
         * Добовляем ключ и значение  поля пипа Entity
         */
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        /**
         * Добавляем новый элемент
         * Метод add(entity) должен вернуть старое значение если ключи совподают если нет то null
         */
        return (V)bucket.add(entity); // Добавляем структуру Entity с его полями в наш связный список пипа bucket
    }

    /**
     * Два конструктора класса HashMap
     */

    public HashMap() {
        buckets = new Bucket[INIT_BUCKET_COUNT]; //Конструктор без параметров (по умолчанию)
    }

    public HashMap(int initCount) {
        buckets = new Bucket[initCount]; // Конструктор с параметром intCount - размерность нашего массива
    }
}
