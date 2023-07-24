package AlgorithmSeminar1;

public class Program {

    public static void main(String[] args) {
        int[] array1 = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array1);
        SortUtils.directSort(array1);
        ArrayUtils.printArray(array1);
    }
}
