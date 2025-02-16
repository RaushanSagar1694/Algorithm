
import java.util.*;

public class DijkstraAlgorithmUsingOrderSet {
    public int[] dijkstraAlgo(int[][] list, int V, int scr){

        //adjcency list
        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] d : list){
            int u = d[0];
            int v = d[1];
            int w = d[2];

            if(!adj.containsKey(u)) adj.put(u, new ArrayList<>());
            if(!adj.containsKey(v)) adj.put(v, new ArrayList<>());

            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }
        

        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);

        //Using Set
        TreeSet<int[]> pq = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        pq.add(new int[]{0, scr});
        result[scr] = 0;
        
        

        //BFS
        while(!pq.isEmpty()){
                int[] curr = pq.removeFirst();
                int u = curr[1];
                int w = curr[0];

                for(int[] d : adj.getOrDefault(u, new ArrayList<>())){
                    int v = d[0];
                    int newWeg = d[1];

                    if(result[v] > w+newWeg){
                        pq.remove(new int[]{result[v], v});
                        
                        result[v] = w+newWeg;
                        pq.add(new int[]{w+newWeg, v});
                    }
                }
        }

        return result;
    }
    public static void main(String[] args) {
        DijkstraAlgorithmUsingOrderSet  obj = new DijkstraAlgorithmUsingOrderSet();

        // Example graph
        int[][] edges = {
            {0, 1, 4}, {0, 2, 1}, {1, 2, 2}, {1, 3, 1}, {2, 3, 5}, {3, 4, 3}
        };
        int V = 5;  // Number of vertices
        int src = 0;  // Source node
        
        //[0, 3, 1, 4, 7]
        int[] distances = obj.dijkstraAlgo(edges, V, src);
        System.out.println(Arrays.toString(distances));
    }
}
