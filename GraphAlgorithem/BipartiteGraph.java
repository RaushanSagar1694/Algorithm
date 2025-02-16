
import java.util.*;

public class BipartiteGraph {
    public static boolean DFS(HashMap<Integer, List<Integer>> adj, int u, int[] color, int currColor){
        color[u] = currColor;
        
        if(adj.containsKey(u)){
            for(int v : adj.get(u)){

                if(color[u] == color[v]) return false;
                if(color[v] == -1 && !DFS(adj, v, color, 1-currColor)){
                    return false;
                }
            }
        }


        return true;
    }
    public static boolean bipartiteGraph(int[][] list, int V){
        // adjcency list
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < V; i++){
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for(int[] l : list){
            int u = l[0];
            int v = l[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++){
            if(color[i] == -1 && !DFS(adj, i, color, 0)){
                return false;
            }
        }


        System.out.println(Arrays.toString(color));
        return true;
    }
    public static boolean BFS(int[][] list, int V){

       // adjcency list
       HashMap<Integer, List<Integer>> adj = new HashMap<>();

       for(int i = 0; i < V; i++){
           adj.putIfAbsent(i, new ArrayList<>());
       }

       for(int[] l : list){
           int u = l[0];
           int v = l[1];

           adj.get(u).add(v);
           adj.get(v).add(u);
       }

       int[] color = new int[V];
       Arrays.fill(color, -1);

       Queue<Integer> pq = new LinkedList<>();
    
       for(int i = 0; i < V; i++){
            if(color[i] == -1 && !bipartiteGraphBFS(adj, i, color, 1)){
                return false;
            }
       }

       return true;
    }
    public static boolean bipartiteGraphBFS(HashMap<Integer, List<Integer>> adj, int u, int[] color, int currColor){
        Queue<Integer> pq = new LinkedList<>();
        color[u] = currColor;
        pq.add(u);

        while(!pq.isEmpty()){
            int size = pq.size();

            while(size--> 0){
                int curr = pq.remove();

                if(adj.containsKey(curr)){
                    for(int v : adj.get(curr)){
                        if(color[v] == color[curr]){
                            return false;
                        }
                        if(color[v] == -1){
                            color[v] = 1 - color[curr];
                            pq.add(v);
                        }
                    }
                }
            }
        }


        return true;
    }
    public static void main(String[] args) {
        int[][][] testCases = {
            { {0, 1}, {1, 2}, {2, 3}, {3, 0} }, // Bipartite (Even Cycle)
            { {0, 1}, {1, 2}, {2, 0} },         // Not Bipartite (Odd Cycle)
            { {0, 1}, {1, 2}, {2, 3}, {3, 0}, {4, 5} }, // Disconnected Bipartite Graph
            { {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 0} }, // Large Bipartite
            { {0, 1}, {1, 2}, {2, 2} },         // Self-Loop (Not Bipartite)
            { },                                // No Edges (Trivially Bipartite)
            { {0, 1}, {0, 3}, {1, 2}, {2, 5}, {3, 4}, {4, 6}, {5, 6} } // Complex Bipartite
        };

        int[] vertices = {4, 3, 6, 8, 3, 5, 7}; // Corresponding number of vertices

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            boolean result = BFS(testCases[i], vertices[i]);
            System.out.println("Is the graph bipartite? " + result);
            System.out.println("---------------------------------------------------");
        }
    }
    
}
