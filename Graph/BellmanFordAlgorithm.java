

import  java.util.*;

public class BellmanFordAlgorithm {
    private static int[] bellmanFordAlgo(int V, int[][] list){
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        
        //make adjecency list
        for(int[] k : list){
            int u = k[0];
            int v = k[1];
            int d = k[2];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new int[]{v, d});
        }
        

        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);

        //source -> scorce distance is 0
        dis[0] = 0;

        for(int i = 1; i <= V-1; i++){
            for(int key : adj.keySet()){
                for(int[] edge : adj.get(key)){
                    int u = key;
                    int v = edge[0];
                    int d = edge[1];

                    if(dis[u] != Integer.MAX_VALUE && dis[u]+d < dis[v]){
                        dis[v] = dis[u]+d;
                    }
                }
            }
        }
        

        //now detect negative cycle
        int count = 0;
        for(int key : adj.keySet()){
            for(int[] edge : adj.get(key)){
                int u = key;
                int v = edge[0];
                int d = edge[1];

                if(dis[u] != Integer.MAX_VALUE && dis[u]+d < dis[v]){
                    count = -1;
                    break;
                }
            }
        }
        
        return count == 0 ? dis : new int[]{-1};
    }
    public static void main(String[] args) {
        int[][] list = {{3, 2, 7}, {5, 3, 2}, {0, 1, 5}, {1, 5, -3}, {1, 2, -2}, {3, 4, -2}, {2, 4, 3}};
        int[][] list2 = {
            {0, 1, 5},  // Edge from 0 to 1 with weight 5
            {1, 0, 3},  // Edge from 1 to 0 with weight 3
            {1, 2, -1}, // Edge from 1 to 2 with weight -1
            {2, 0, 1}   // Edge from 2 to 0 with weight 1
        };

        int  v = 6;
        int v2 = 3;

       int result [] = bellmanFordAlgo(v2, list2);

       System.out.println(Arrays.toString(result));
    }
}
