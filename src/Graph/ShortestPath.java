package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {
    private Graph G; // 图的引用
    private int s; // 起始点
    private boolean[] visited; // 记录dfs的过程节点是否被访问
    private int[] from; //记录路径，from[i] 表示查找的路径上i的上一个节点
    private int[] ord; //记录路径中节点的次序。ord[i] 表示i节点在路径中的次序


    public ShortestPath(Graph graph, int s) {
        G = graph;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;

        // 无向图最短路径算法, 从s开始广度优先遍历整张图
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int i : G.adj(v)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
            }
        }
    }

    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    public Vector<Integer> path(int w) {
        assert hasPath(w);
        Stack<Integer> s = new Stack<>();
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }
        Vector<Integer> res = new Vector<Integer>();
        while (!s.empty())
            res.add(s.pop());

        return res;
    }

    public void showPath(int w) {

        assert hasPath(w);
        Vector<Integer> vec = path(w);
        for (int i = 0; i < vec.size(); i++) {
            System.out.println(vec.elementAt(i));
            if(i == vec.size() -1){
                System.out.println();
            }else {
                System.out.println(" ->");
            }
        }
    }
    public int length(int w){
        assert w >= 0 && w < G.V();
        return ord[w];
    }


}
