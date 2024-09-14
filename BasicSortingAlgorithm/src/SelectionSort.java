

import java.util.*;

public class SelectionSort {
    public static void selectionSort(int[] arr){

        for(int i = 0; i < arr.length-1; i++){
            int minIdx = i;

            for(int j = i+1; j < arr.length; j++){
                if(arr[minIdx] > arr[j]){
                    minIdx = j;
                }
            }

            //swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {29, 72, 98, 13, 87, 66, 52, 51, 36};
        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
