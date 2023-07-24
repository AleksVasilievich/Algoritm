package AlgorithmSeminar1;

public class SortUtils {
    /**
     * Сортировка выбором
     * @param array
     */
    public static void directSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int saveIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[saveIndex]){
                    saveIndex = j;
                }
            }
            if (saveIndex != i){
                int buf = array[i];
                array[i] = array[saveIndex];
                array[saveIndex] = buf;
            }
        }
    }
}
