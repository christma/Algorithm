package UnoinFind;

public class UnionFind {

    private int[] id;
    private int count;

    public UnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }
        for (int i = 0; i < count; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
