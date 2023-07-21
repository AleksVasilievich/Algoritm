package Homework;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[] {
                4, 2, 5, 7, 6, 8, 1, -7, 3, 9
        };
        heapSort(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] +  " ");
        }
    }
    public static void heapSort(int[] array){
        //Построение кучи (перегруперуем массив)
        for (int i = array.length  / 2 - 1; i >= 0; i--)
            samleHeap(array, array.length, i);

        // Один за другим извлекаем элементыы из кучи
        for (int i = array.length - 1; i >= 0; i--){
            // Перемещаем текущий корень в конец
            int  temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру samleHeap на уменьшеной куче
            samleHeap(array, i, 0);
        }
    }
    private static void samleHeap(int[] array, int heapSize, int rootIndex){
        int maxNum = rootIndex; // Инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; //Левый = 2 * roorIndex + 1
        int rightChild = 2 * rootIndex + 2; // Правый = 2 * roorIndex + 2

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[maxNum])
            maxNum = leftChild;

        // Если правый элемент больше , чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[maxNum])
            maxNum = rightChild;
        // Если самый большой элемент не корень
        if (maxNum != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[maxNum];
            array[maxNum] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            samleHeap(array, heapSize, maxNum);
        }
    }



}
