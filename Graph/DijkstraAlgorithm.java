import java.util.*;




// part 1
// using priorityQueue
public class DijkstraAlgorithm {
    static class Pair{
        int val;
        int weg;

        public Pair(int val, int weg){
            this.val = val;
            this.weg = weg;
        }
    }
    public static int[] Dijkstra(int[][] list, int scr, int V){
        HashMap<Integer, List<Pair>> adj = new HashMap<>();

        // create adjency list
        for(int[] k : list){
            int u = k[0];
            int v = k[1];
            int weg = k[2];

            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            if(!adj.containsKey(v)){
                adj.put(v, new ArrayList<>());
            }

            adj.get(u).add(new Pair(v, weg));
            adj.get(v).add(new Pair(u, weg));
        }

        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a.weg));
        pq.add(new Pair(scr, 0));
        result[scr] = 0;


        while(!pq.isEmpty()){
            Pair p1 = pq.remove();
            int u = p1.val;
            int prevWeg = p1.weg;

            for(Pair p2 : adj.get(u)){
                int v = p2.val;
                int currWeg = p2.weg;

                if(result[v] > prevWeg+currWeg){
                    result[v] = prevWeg+currWeg;
                    pq.add(new Pair(v, prevWeg+currWeg));
                }
            }
        }
        

        return result;
    }

    // part 2 using HashSet
    public static int[] DijkstraAlgo(int[][] list, int scr, int V){
        HashMap<Integer, List<Pair>> adj = new HashMap<>();

        // create adjency list
        for(int[] k : list){
            int u = k[0];
            int v = k[1];
            int weg = k[2];

            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            if(!adj.containsKey(v)){
                adj.put(v, new ArrayList<>());
            }

            adj.get(u).add(new Pair(v, weg));
            adj.get(v).add(new Pair(u, weg));
        }

        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);


        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a.weg));
        pq.add(new Pair(scr, 0));
        result[scr] = 0;
        HashSet<Integer> st = new HashSet<>();


        while(!pq.isEmpty()){
            Pair p1 = pq.remove();
            int u = p1.val;
            int prevWeg = p1.weg;

            // ignore already visited element
            if(st.contains(u)) continue;
            st.add(u);

            for(Pair p2 : adj.get(u)){
                int v = p2.val;
                int currWeg = p2.weg;

                if(result[v] > prevWeg+currWeg){
                    result[v] = prevWeg+currWeg;
                    pq.add(new Pair(v, prevWeg+currWeg));
                }
            }
        }
        

        return result;
    }
    public static void main(String[] args) {
        int[][] list = {{2, 0, 6}, {2, 1, 3}, {0, 2, 6}, {0, 1, 1}, {1, 2, 3}, {1, 0, 1}};
        int src = 2;
        int v = 3;
        int[] result = DijkstraAlgo(list, 2, 3);

        System.out.println("Shortest distances from source " + src + ": " + Arrays.toString(result));
    }
}
