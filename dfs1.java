import java.util.*;
public class dfs1 {
    

    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges (directed graph for cycle detection and topological sort)
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 3, 1));

        // Uncomment to create a cycle
        // graph[3].add(new Edge(3, 0, 1));
    }

    public static boolean isCycleDirected(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] rec) {
        vis[curr] = true;
        rec[curr] = true;

        for (Edge e : graph[curr]) {
            if (rec[e.dest]) {
                return true; // cycle found
            } else if (!vis[e.dest]) {
                if (isCycleDirected(graph, vis, e.dest, rec)) {
                    return true;
                }
            }
        }

        rec[curr] = false;
        return false;
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }

        stack.push(curr);
    }

    public static void topSort(ArrayList<Edge>[] graph, int V) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, stack);
            }
        }

        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    public static boolean isCycleUndirected(ArrayList<Edge> graph[],boolean vis[], int curr ,int par){
        vis[curr]= true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest]&& e.dest !=par){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCycleUndirected(graph, vis ,e.dest ,curr)){
                    return true;
                }
    public static void dijkstra(ArrayList<Edge> graph[],int src,int V){
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        int dist[]=new int[V];
        for(int i =0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean vis[] =new boolean[V];

        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair curr =pq.remove();
            if(!vis[curr.node]){
            }
        
        }
        return false;

    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int n ,int d){
          this.node =n;
          this.dist =d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist -p2.dist;
        }

    }

                vis[curr.node] =true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int u =e.src;
                    int v =e.dest;
                    if(dist[u]+e.wt<dist[v]){
                        dist[v]=dist[u]+e.wt;
                        pq.add(new Pair(v,dist[v]));
                    }

                }
            }
            
        }
        for(int i =0;i<V;i++){
            System.out.println(dist[i]+ " ");
        }
        System.out.println();
    }




    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        // System.out.println(isCycleUndirected(graph,new boolean[V],curr,-1));

        // Check cycle
        // boolean[] visited = new boolean[V];
        // boolean[] recStack = new boolean[V];
        // boolean cycleExists = false;

        // for (int i = 0; i < V; i++) {
        //     if (!visited[i]) {
        //         if (isCycleDirected(graph, visited, i, recStack)) {
        //             cycleExists = true;
        //             break;
        //         }
        //     }
        // }

        // System.out.println("Cycle exists in directed graph: " + cycleExists);

        // // Only do topological sort if no cycle
        // if (!cycleExists) {
        //     topSort(graph, V);
        // }
        int src =0;
        dijkstra(graph,src,V);
    }
}
    


    
    

