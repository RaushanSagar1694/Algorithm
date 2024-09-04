public class PairInAnArray {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};

        for(int i = 0; i < arr.length; i++){
            int x = arr[i];
            for(int j = i+1; j < arr.length; j++){
                int y = arr[j];
                System.out.print("("+x+","+y+")");
            }
            System.out.println();
        }
    }
}
