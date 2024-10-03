public class BinarySearch {
    public static int binarySearch(int[] arr, int key){
        int si = 0;
        int ei = arr.length-1;

        while (si <= ei){
            int mid = si + (ei - si)/2;

            if(arr[mid] == key) {
                return mid;
            }
            if(arr[mid] > key){
                ei = mid -1;
            }
            else {
                si = mid +1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int key = 7;

        int result = binarySearch(arr, key);

        if(result == -1){
            System.out.println("Key not found at any index");
        }
        else {
            System.out.println("Key found at index:"+result);
        }
    }
}
