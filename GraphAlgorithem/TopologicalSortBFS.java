
// Diracted Graph BFS
import java.util.*;

public class TopologicalSortBFS {
    public static  int[] BFS(int[][] list, int V){
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


        System.out.println(Arrays.toString(indegree));

        //Queue
        Queue<Integer> pq = new LinkedList<>();
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                pq.add(i);
            }
        }
        

        //Store Result
        int[] result = new int[V];
        int k = 0;


        //BFS
        while(!pq.isEmpty()){
            int u = pq.remove();
            result[k++]  = u;

            if(adj.containsKey(u)){

                for(int v : adj.get(u)){
                    indegree[v]--;

                    if(indegree[v] == 0){
                        pq.add(v);
                    }
                }
            }
        }
        

        return result;
    }
    public static void main(String[] args) {
        int[][] list = {{0, 3}, {0, 2}, {2, 3}, {2, 1}, {3, 1}, {1, 4}, {5, 1}, {5, 4}};
        int v = 6;
        int[] result = BFS(list, v);

        System.out.println(Arrays.toString(result));
    }
}