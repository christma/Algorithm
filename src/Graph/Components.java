package Graph;

public class Components {
    Graph G;
    private boolean[] visited;
    private int ccount;
    private int[] id;

    void dfs(int v) {

        visited[v] = true;
        id[v] = ccount;

        for (int i : G.adj(v)) {
            if (!visited[i])
                dfs(i);
        }
    }

    public Components(Graph graph) {
        G = graph;
        visited = new boolean[G.V()];
        id = new int[G.V()];

        ccount = 0;
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }

        }
    }

    int count() {
        return ccount;
    }

    // 查询点v和点w是否联通
    boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }

}
