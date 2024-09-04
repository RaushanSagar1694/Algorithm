

public class LinearSearch {
    public static int findKey(int[] arr, int key){

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12,14,16,3};
        int key = 3;
        // call function
        int result = findKey(arr, key);


        if(result == -1) {
            System.out.println("Key not found at any index");
        }
        else {
            System.out.println("Key found at index: "+result);
        }
    }
}
