package AlgorithmLesson3;

/**
 * Связный список : базовая структура данных, состоящяя из узлов,
 * где каждый узел содержит одну или две ссылки,
 * который ссылается на следующий или на следующий и предыдущий узел соответственно
 * (Однонаправленный или Двунаправленный)
 */
public class List {
    Node head;             // Сылка  на первый элемент списка
    Node tail;             // Сылка  на последний элемент списка

    // Добавления в конец

    public void add(int value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    // Добавление в серидину

    public void add(int value,Node node){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null){
            tail = newNode;
        }else {
            next.previous = node;
            newNode.next = next;
        }
    }

    // Удаление элемента

    public void delete(Node node){
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null){
            previous.next = null;
            head = next;
        }else {
            if (next == null){
                previous.next = null;
                tail = previous;
            }else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    public Node find(int value){
        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.value != value){
                return  currentNode;
            }
            currentNode = currentNode.next;
        }
        return  null;
    }

    // Разворот Списка

    public void revert(){
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null){
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public class Node {
        int value;
        Node next;          // ССылка на следующий элемент (Node)
        Node previous;      // Ссылка на предидущий элемент (Node)
    }
}
