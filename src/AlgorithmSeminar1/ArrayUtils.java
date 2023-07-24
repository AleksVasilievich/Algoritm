package AlgorithmSeminar1;

import java.util.Random;

/**
 * Утилиты для работы с массивами
 */

public class ArrayUtils {
    public static Random random = new Random();

    /**
     * Подготовить массив случайных чисел
     */
/**
    public static  int[] prepareArray() {
        int[] array = new int[random.nextInt(10, 15)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-99, 100);
        }
        return array;
    }
*/
    public static  int[] prepareArray() {
        return prepareArray(random.nextInt(10,15));
    }
    public static  int[] prepareArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-99, 100);
        }
        return array;
    }


    /**
     * Распечатать массив на консоль
     */
    public static void printArray(int[] array){
        for (int e: array) {
            System.out.printf("%d\t", e);
        }
        System.out.println();
    }
}
