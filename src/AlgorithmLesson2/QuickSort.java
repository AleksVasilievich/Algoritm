package AlgorithmLesson2;


public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[] {
                3, 5, 1, -6, 0, 7, -8
        };
        quickSort(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

    }

    public static int quickSort(int[] array){
        return quickSort(array, 0,6);
    }


    public static int quickSort(int[] array, int start, int end){
        int left = start;
        int right = end;
        int pivot = array[(start + end) / 2];
        do {
            while (array[left] < pivot){
                left++;
            }
            while (array[right] > pivot){
                right--;
            }
            if (left <= right){
                if (left < right){
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }
                left++;
                right--;
            }
        }
        while (left <= right);

        if (left < end){
            quickSort(array, left, end);
        }
        if (start < right){
            quickSort(array, start, right);
        }
        //return left;
        return left;
    }

}
