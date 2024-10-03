import java.util.Arrays;

public class ReverseAnArray {
    public static int[] reverseArray(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        int idx = 0;

        for(int i = n-1; i >= 0; i--){
            temp[idx++] = arr[i];
        }


        return temp;
    }
    public static void  recursive(int si, int ei, int[] arr, int idx){
        if(si >= ei){
            return;
        }
        idx = arr[si];
        recursive(si, ei, arr,idx);
        System.out.println(idx);
    }
    public static void main(String[] args) {
        int[] arr = {1,4,6,8,10,12};

        //int[] result = reverseArray(arr);
        recursive(0, arr.length, arr,0);
        System.out.println(Arrays.toString(arr));
    }
}
