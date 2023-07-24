package AlgorithmLesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * Дерево это структура данных, представленная в виде набора связанных узлов
 * Можно представить в виде набора узлов связаных друг с другом рёбрами
 * Все элементы дерева называют узлами(Node). Узлы которые не имеют детей называтся листьями.
 */

public class Tree {
    Node root; //Корень - Самая верхняя Нода(узел) не имеет родителей.

    /**
     * Обход дерева в глубину
     * @param value
     * @return
     */

    public boolean exist(int value){
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return  true;
            }
        }
        return false;
    }

    /**
     * Обход дерева в глубину
     * Поиск Node с определённым значением внутри
     * @param node искомая node
     * @param value значение
     * @return
     */
//    private Node find(Node node, int value){
//        if (node.value == value){
//            return node;
//        } else {
//            for (Node child : node.children){
//                Node result = find(child, value);
//                if (result != null){
//                    return  result;
//                }
//            }
//        }
//        return null;
//    }


    /**
     * Обход дерева в ширину (Более затратный с точки зрения памяти)
     */
    private  Node find(Node root, int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }




    public class Node {
        int value;
        List<Node> children;
    }
}
