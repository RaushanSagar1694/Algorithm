import java.util.Arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {1,-2,6,-1,3};

        //prefix arr
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i = 0; i < prefix.length; i++){
            for(int j = i; j < prefix.length; j++){
                int sum = 0;
                if(i == 0){
                    sum = prefix[j];
                }
                else{
                    sum = prefix[j] - prefix[i-1];
                }
                System.out.println("sub Array sum is: "+sum);
            }
        }

        System.out.println(Arrays.toString(prefix));
    }
}
