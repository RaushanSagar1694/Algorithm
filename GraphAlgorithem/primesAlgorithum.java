import java.util.List;
import java.util.PriorityQueue;

public class primesAlgorithum {
    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        
        //visted array
        boolean[] vis = new boolean[V];
        
        
        //min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0});
        
        //add result sum
        int sum = 0;
        
        //BFS traversal
        while(!pq.isEmpty()){
            int[] temp = pq.remove();
        
            int u = temp[1];
            int uWeg = temp[0];
    
            
            if(vis[u] == true) continue;
            vis[u] = true;
            
            //add sum 
            sum += uWeg;
            
            
            //find neighbout
            for(int[] pair : adj.get(u)){
                int v = pair[0];
                int vWeg = pair[1];
                
                if(vis[v] == true) continue;
                pq.add(new int[]{vWeg, v});
            }
        }
        
        
        return sum;
    }
    public static void main(String[] args) {
        
    }
}
