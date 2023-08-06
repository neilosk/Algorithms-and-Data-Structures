import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Graph;
import java.util.HashMap;
import java.util.HashSet;

public class Undirected {
    private Queue<Integer> queue = new Queue<>();
    private int[] edgeTo;
    private boolean[] marked;

    private HashMap<Integer, HashSet<Integer>> connected = new HashMap<>();

    private boolean isBipartite = true;

  
    private static boolean vIsNotColored = false;
    
    
    private boolean[] color;

    public Undirected(Graph G, HashMap<Integer, HashSet<Integer>> connected) {
        isBipartite = true;
        this.connected = connected;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        
        for (int v = 0; v < G.V() && isBipartite; v++) {
            if (!marked[v]) {
                bfs(G, v);
            }
        }
    }

    private Boolean isHarmonious(int v, int w) {
        if (this.connected.containsKey(v) && this.connected.get(v).contains(w)) {
            if (this.connected.containsKey(w) && this.connected.get(w).contains(v)) {
                return true;
            }
        }
        return false;
    }

    private void bfs(Graph g, int s) {
        color[s] = vIsNotColored;
        queue.enqueue(s);
        marked[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;

                    if(isHarmonious(v, w)){
                        color[w] = color[v];
                        } else {
                        color[w] = !color[v];   
                    }
                    queue.enqueue(w);
                } else if (color[w] == color[v] && !isHarmonious(v, w)) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }

    public boolean isBipartite() {
        return isBipartite;
    }

}

