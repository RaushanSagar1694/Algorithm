import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int si, int ei, int[] arr){
        if(si >= ei){
            return;
        }

        int mid = si + (ei - si)/2;
        mergeSort(si, mid, arr);
        mergeSort(mid+1, ei, arr);

        merge(arr, si, mid, ei);
    }
    public static void merge(int[] arr, int si, int mid, int ei){
        int[] temp = new int [ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }


        //Remainig arr
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= ei){
            temp[k++] = arr[j++];
        }


        for(k = 0, i = si; k < temp.length; i++,k++){
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,5,8,9,3,0,1,4};
        int si = 0;
        int ei = arr.length-1;
        mergeSort(si, ei, arr);

        String str = Arrays.toString(arr);
        System.out.println(str);
    }
}
