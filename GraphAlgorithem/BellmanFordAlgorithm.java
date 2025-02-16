




// Bellman Ford Algorithm

import java.util.*;
public class BellmanFordAlgorithm {
    public static int[] floydWarshallAlgorithm(int[][] edges, int V){

        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int count = 0; count <= V-1; count++){
            for(int[] list : edges){
                int u = list[0];
                int v = list[1];
                int w = list[2];

                if(dis[u] != Integer.MAX_VALUE && dis[u]+w < dis[v]){
                    dis[v] = dis[u]+w;
                }
            }
        }

        for(int[] list : edges){
            int u = list[0];
            int v = list[1];
            int w = list[2];

            if(dis[u] != Integer.MAX_VALUE && dis[u]+w < dis[v]){
                return new int[]{-1};
            }
        }

        return dis;
    }
    public static void main(String[] args) {
        
    }
}
