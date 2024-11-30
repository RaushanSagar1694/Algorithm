
import java.util.Arrays;



public class FloyedWarshallAlgo {
    private static int[][] floyedWarshallAlgo(int V, int[][] list){
        int[][] grid = new int[V][V];

        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(i == j){
                    grid[i][j] = 0;
                }
                else if(grid[i][j] == -1){
                    grid[i][j] = Integer.MAX_VALUE;
                }
                else{
                    grid[i][j] = list[i][j];
                }
            }
        }
        
        //find shortest distance
        for(int via = 0; via < V; via++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){

                    // Avoid overflow and handle infinity correctly
                    if (grid[i][via] != Integer.MAX_VALUE && grid[via][j] != Integer.MAX_VALUE) {
                        grid[i][j] = Math.min(grid[i][j], grid[i][via] + grid[via][j]);
                    }
                }
            }
        }

        //detect negative cycle
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(i == j && grid[i][j] < 0){
                    return new int[][]{{-1}};
                }
            }
        }


        return grid;
    }
    public static void main(String[] args) {
        int[][] list =   {{0, 25}, {-1, 0}};
        int result[][] = floyedWarshallAlgo(2, list);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
    
}
