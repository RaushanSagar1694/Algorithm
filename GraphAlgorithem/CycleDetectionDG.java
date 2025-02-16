
import java.util.*;

class DAG{
    //DFS
    public boolean isCycle( HashMap<Integer, List<Integer>> adj, int curr, boolean [] vis, boolean [] inRecursion){
        vis[curr] = true;
        inRecursion[curr] = true;

        if(adj.containsKey(curr)){

            for(int nb : adj.get(curr)){
                
                if(!vis[nb] && isCycle(adj, nb, vis, inRecursion)){
                    return true;
                }
                else if(inRecursion[nb] == true){
                    return true;
                }
            }
        }

        //backtraking
        inRecursion[curr] = false;

        return false;
    }
    public boolean isCycleDFS(int[][] list, int V){

        // adjcency List
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] l : list){
            int u = l[0];
            int v = l[1];

            if(!adj.containsKey(u)) adj.put(u, new ArrayList<>());
            adj.get(u).add(v);
        }

        //visted 
        boolean[] vis = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i] && isCycle(adj, i, vis, inRecursion)){
                return true;
            }
        }

        return false;
    }

    //KHAN'S Algorithum
    //BFS Cycle Detection 
    public static  boolean BFS(int[][] list, int V){
        //adjecency list
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        //indegree
        int[] indegree = new int[V];

        for(int[] l : list){
            int u = l[0];
            int v = l[1];

            indegree[v]++;

            if(!adj.containsKey(u)) adj.put(u, new ArrayList<>());
            adj.get(u).add(v);
        }

        //Queue
        Queue<Integer> pq = new LinkedList<>();
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                pq.add(i);
            }
        }

        int count = 0;

        while(!pq.isEmpty()){
            int u = pq.remove();
            count++;

            if(adj.containsKey(u)){
                for(int v : adj.get(u)){
                    indegree[v]--;

                    if(indegree[v] == 0){
                        pq.add(v);
                    }
                }
            }
        }


        return count != V;
    }

    public static void main(String[] args) {

        int[][] test1 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};  // No cycle
        int[][] test2 = {{0, 1}, {1, 2}, {2, 3}, {3, 1}};  // Cycle exists
        int[][] test3 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}};  // Cycle exists
        int[][] test4 = {{0, 1}, {2, 3}};  // No cycle (Disconnected components)

        System.out.println("Test 1 (No Cycle): " + BFS(test1, 5)); // false
        System.out.println("Test 2 (Cycle Exists): " + BFS(test2, 4)); // true
        System.out.println("Test 3 (Cycle Exists): " + BFS(test3, 5)); // true
        System.out.println("Test 4 (No Cycle): " + BFS(test4, 4)); // false









        // DAG graph = new DAG();

        // // Test Case 1: DAG (No Cycle)
        // int[][] edges1 = {
        //     {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 4}, {3, 4}
        // };
        // System.out.println("Test Case 1 (DAG - No Cycle): " + graph.isCycleDFS(edges1, 5)); // Expected: false

        // // Test Case 2: Graph with Cycle
        // int[][] edges2 = {
        //     {0, 1}, {1, 2}, {2, 3}, {3, 1} // Cycle: 1 -> 2 -> 3 -> 1
        // };
        // System.out.println("Test Case 2 (Graph with Cycle): " + graph.isCycleDFS(edges2, 4)); // Expected: true

        // // Test Case 3: Self Loop (Cycle)
        // int[][] edges3 = {
        //     {0, 0} // Self-loop (cycle)
        // };
        // System.out.println("Test Case 3 (Self Loop): " + graph.isCycleDFS(edges3, 1)); // Expected: true

        // // Test Case 4: Disconnected Graph (No Cycle)
        // int[][] edges4 = {
        //     {0, 1}, {2, 3}, {3, 4}
        // };
        // System.out.println("Test Case 4 (Disconnected Graph - No Cycle): " + graph.isCycleDFS(edges4, 5)); // Expected: false
    }
}