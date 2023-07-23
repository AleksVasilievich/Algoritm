package Homework;

public class List2 {
    Node head;

    public static void main(String[] args) {
        List2 list = new List2();
        list.add(3);
        list.add(5);
        list.add(0);
        list.add(1);
        list.add(8);
        list.add(4);
        list.print();
        System.out.println();
        list.revert();
        list.print();

    }

    /**
     * Печать на консоль
     */

    public void print(){
        Node node = head;
        while (node != null){
            System.out.print(node.value);
            node = node.next;
        }
    }


    /**
     * Добавление в начало списка
     * @param value элемент
     */

   public void add(int value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.next = head;
        }
        head = node;
   }


    /**
     * Разварот списка
     */

    public void revert(){
        if (head != null && head.next != null){
            Node temp = head;
            revert(head.next, head);
            temp.next = null;
        }
    }

    public void revert(Node currentNode, Node previousNode){
        if (currentNode.next == null){
            head = currentNode;
        }else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
    }

    public class Node {

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        int value;
        Node next;
    }
}

