import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){

        for(int i = 1; i < arr.length; i++){
            int curr = arr[i];
            int prev = i-1;

            while (prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }

            //insertion
            arr[prev+1] = curr;

        }
    }
    public static void main(String[] args) {
        int[] arr = {29, 72, 98, 13, 87, 66, 52, 51, 36};
        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
