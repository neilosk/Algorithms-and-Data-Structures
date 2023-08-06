import java.util.Scanner;

// import edu.princeton.cs.algs4.UF;
// import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdOut;


public class DisjointSets {

    public static int[] parent;

    public static int find(int i) {
        while(i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    public static boolean query(int p, int q) {
        return find(p) == find(q);
    }

    public static void union (int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        parent[pRoot] = qRoot;
    }

    public static void move (int s, int t){
        int rootS = find(s);
        int rootT = find(t);

        if(rootS == rootT) {
            return;
        }

        if(s == rootS) {
            int temp = -1;
            for(int i = 0; i < parent.length; i++) {
                if(parent[i] == s && s != i) {
                    if(temp == -1) {
                        temp = i;
                        parent[temp] = temp;
                    } else {
                        parent[i] = temp;
                    }
                }
            }
        } else {
            for(int j = 0; j < parent.length; j++) {
                if(parent[j] == s) {
                    parent[j] = rootS;
                }
            }  
        }
        parent[s] = rootT;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int c = sc.nextInt();
            int s = sc.nextInt();
            int t = sc.nextInt();

            if(c == 0) {
                System.out.println(query(s,t) ? 1 : 0);
            } else if(c == 1) {
                union(s,t);
            } else if(c == 2) {
                move(s,t);
            }
        }
        sc.close();
    }
}
