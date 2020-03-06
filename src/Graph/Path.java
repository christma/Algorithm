package Graph;

import java.util.Stack;
import java.util.Vector;

public class Path {
    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] from;

    private void dfs(int v) {
        visited[v] = true;
        for (int i : G.adj(v)) {
            from[i] = v;
            dfs(i);
        }
    }

    public Path(Graph graph, int s) {
        G = graph;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;
        dfs(s);
    }

    boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    Vector<Integer> path(int w) {
        assert hasPath(w);
        Stack<Integer> s = new Stack<>();

        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }
        Vector<Integer> res = new Vector<>();

        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }
    void showPath(int w){
        assert hasPath(w);
        Vector<Integer> vec = path(w);
        for (int i = 0; i < vec.size(); i++) {
            System.out.println(vec.elementAt(i));
            if(i == vec.size() - 1){
                System.out.println();
            }else {
                System.out.println(" ->");
            }
        }
    }

}
