public class LargestNum {
    public static int findLargestNumber(int[] arr){
        int result = Integer.MIN_VALUE;


        for (int k : arr){
            if(result < k){
                result = k;
            }
        }


        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,9};

        int result = findLargestNumber(arr);

        if(Integer.MIN_VALUE == result){
            System.out.println("Given arr is Empty");
        }
        else{
            System.out.println("Largest no : "+result);
        }
    }
}
