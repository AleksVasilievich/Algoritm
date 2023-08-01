package AlgorithmSeminar4_1;

/**
 * Хеш Таблица
 * Структура - Внутри ячейки лежат "Бакеты" , Внутри "Бакетов" лежат "Узлы", Внутри каждого "Узла" лежат ключ и значение
 * Создадим свою структуру данных
 * @param <K>  ключ
 * @param <V> значние
 */

public class HashMap<K, V> {

    private static final int INIT_BUCKET_COUNT = 16; // Начальная размерность массива Backet[]
    private static final double LOAD_FACTOR = 0.5;  // Фактор расширения ассива Backet[]

    private int size;

    public int getSize() {
        return size;
    }


    private Bucket[] buckets; // Наша Структура данных HashMap будет содержать массив backets (связных списков)

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
            Node node = new Node();//Подготавливаем новый узел Node каторый хранит соответствующее значение
            node.value = entity;
            if (head == null){  //Если элементов нет (В списке  Bucket[] нет Node (Узлов), то
                head = node;   // Первому элементу присваиваем значение и возвращаем null т.к совпадений небыло
                return null;
            }
            Node currentNode = head;  // Если элементы есть то пройдёмся и сравним узлы по значению
            while (true) {
                if (currentNode.value.key.equals(entity.key)) {
                    V buf = (V) currentNode.value.value;
                    currentNode.value.value = entity.value;
                    return buf;
                }
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    currentNode.next = node;
                    return null;
                }
            }
        }

        /**
         * Находим значение по ключю
         */

        public V get(K key) {
            Node node = head;
            while (node != null) {
                if (node.value.key.equals(key)) {
                    return (V) node.value.value;
                }
                node = node.next;
            }
            return null;
        }
        public V remove(K key) {
            if (head == null)
                return null;
            if (head.value.key.equals(key)) {
                V buf = (V) head.value.value;
                head = head.next;
                return buf;
            } else {
                Node node = head;
                while (node.next != null) {
                    if (node.next.value.key.equals(key)) {
                        V buf = (V) node.next.value.value;
                        node.next = node.next.next;
                        return buf;
                    }
                    node = node.next;
                }
                return null;
            }
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
     * Метод рекалькуляции массива бакетов(Увеличения длины массива в два раза)
     */
    private void recalculate() {
        size = 0;
        Bucket<K, V>[] old = buckets;
        buckets = new Bucket[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            Bucket<K, V> bucket = old[i];
            if (bucket != null) {
                Bucket.Node node = bucket.head;
                while (node != null) {
                    put((K) node.value.key, (V) node.value.value);
                    node = node.next;
                }
            }
            old[i] = null;
        }
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
        if (buckets.length * LOAD_FACTOR <= size) { // Если количество элементов >= половине дленны массива
            recalculate();                          // проводим реколькуляцию (увеличим длину массива в два раза)
        }
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
        V res = (V)bucket.add(entity);// Добавляем структуру Entity с его полями в наш связный список пипа bucket
        if (res == null) {
            size++;
        }
        return res;
    }

    /**
     * Находим значение по ключю
     */
    public V get(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        return (V) bucket.get(key);
    }

    public V remove(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        V res = (V) bucket.remove(key);
        if (res != null) {
            size--;
        }
        return res;
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
