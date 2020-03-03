package Graph;

import java.util.Vector;

public class SparseGraph implements Graph {

    private int n; // 节点数
    private int m; // 边数
    private boolean directed;
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Integer>();
        }
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++)
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }

    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

    public static void main(String[] args) {

        SparseGraph graph = new SparseGraph(7, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 6);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        System.out.println(graph.V());
    }

}

