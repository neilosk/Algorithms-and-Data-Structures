import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Graph;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    
    public static void main(String[] args)  {
        HashMap<Integer, HashSet<Integer>> connectedInHarmony = new HashMap<>();
        int ve = StdIn.readInt();
        int ed = StdIn.readInt();

        Graph graph = new Graph(ve);

        for (int i = 0; i < ed; i++) {
            int u = StdIn.readInt();
            int v = StdIn.readInt();
            int n = StdIn.readInt();

            graph.addEdge(u, v);

            if(n == 0){
                HashSet<Integer> edgeSet = new HashSet<>();
                edgeSet.add(u);
                edgeSet.add(v);

                if(connectedInHarmony.containsKey(u)){
                    connectedInHarmony.get(u).add(v);    
                    } else{
                    connectedInHarmony.put(u, edgeSet);
                }

                if(connectedInHarmony.containsKey(v)){
                    connectedInHarmony.get(v).add(u);    
                    } else{
                    connectedInHarmony.put(v, edgeSet);
                }
            }
            
        }

        Undirected undirected = new Undirected(graph, connectedInHarmony);

        if(undirected.isBipartite()){
            System.out.println(1);
            } else{
            System.out.println(0);
        }

       
    }
}
