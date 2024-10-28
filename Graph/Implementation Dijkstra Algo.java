import java.util.*;

class DijkstraAlgo{
    static class Pair implements Comparable<Pair>{
        int val;
        int weg;

        public Pair(int val, int weg){
            this.val = val;
            this.weg = weg;
        }

        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.weg, other.weg);
        }
    }

    //dijkstra Algo Using PriorityQueue
    public static void dijkstraAlgoUsingPriorityQueue(int V, int[][] list, int scr){
        HashMap<Integer, List<Pair>> adj = new HashMap<>();

        for(int[] k : list){
            int u = k[0];
            int v = k[1];
            int w = k[2];

            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            if(!adj.containsKey(v)){
                adj.put(v, new ArrayList<>());
            }

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(scr, 0));
        int[] result = new int[V];

        Arrays.fill(result, Integer.MAX_VALUE);
        result[scr] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int u = curr.val;
            int prevWeg = curr.weg;

            for(Pair k : adj.get(u)){
                int v = k.val;
                int currWeg = k.weg;
                
                if(prevWeg + currWeg < result[v]){
                    result[v] = prevWeg + currWeg;
                    pq.add(new Pair(v, prevWeg + currWeg));
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }

     //dijkstra Algo Using HashSet
     public static void dijkstraAlgoUsingHashSet(int V, int[][] list, int scr){
        HashMap<Integer, List<Pair>> adj = new HashMap<>();

        for(int[] k : list){
            int u = k[0];
            int v = k[1];
            int w = k[2];

            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            if(!adj.containsKey(v)){
                adj.put(v, new ArrayList<>());
            }

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        HashSet<Pair> pq = new HashSet<>();
        pq.add(new Pair(scr, 0));
        int[] result = new int[V];

        Arrays.fill(result, Integer.MAX_VALUE);
        result[scr] = 0;

        while(!pq.isEmpty()){
            Iterator<Pair> it = pq.iterator();
            Pair curr = it.next();

            int u = curr.val;
            int prevWeg = curr.weg;

            for(Pair k : adj.get(u)){
                int v = k.val;
                int currWeg = k.weg;
                
                if(prevWeg + currWeg < result[v]){
                    Pair p = new Pair(v, result[v]);
                    if(pq.contains(p)){
                        pq.remove(p);
                    }

                    result[v] = prevWeg + currWeg;
                    pq.add(new Pair(v, prevWeg + currWeg));
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }
    public static void main(String[] args) {
        int[][] list = {{0, 1, 1}, {0, 2, 6}, {1, 2, 3}};
        int v = 3;

        dijkstraAlgoUsingHashSet(v, list, 2);
    }
}