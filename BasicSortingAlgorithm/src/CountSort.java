
import java.util.*;
public class CountSort {
    public static void countSort(int[] arr){

        int largest = Arrays.stream(arr).max().getAsInt();

        int[] temp = new int[largest+1];
        for (int i = 0; i < arr.length; i++){
            temp[i]++;
        }

        int idx = 0;
        for(int i = 0; i < temp.length; i++){
            int n = temp[i];
            while (n--> 0){
                arr[idx++] = i;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {29, 72, 98, 13, 87, 66, 52, 51, 36};
        countSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
