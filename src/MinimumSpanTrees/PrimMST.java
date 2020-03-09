package MinimumSpanTrees;

import java.util.Vector;

public class PrimMST<Weight extends Number & Comparable> {

    private WeightedGraph G;
    private IndexMinHeap<Weight> iqp;
    private Edge<Weight>[] edgeTo;
    private boolean[] marked;
    private Vector<Edge<Weight>> mst;
    private Number mstWeight;

    public PrimMST(WeightedGraph graph) {
        G = graph;
        assert (graph.E() >= 1);
        iqp = new IndexMinHeap<>(graph.V());

        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        for (int i = 0; i < G.V(); i++) {
            marked[i] = false;
            edgeTo[i] = null;
        }
        mst = new Vector<>();
        visit(0);
        while (!iqp.isEmpty()) {
            int v = iqp.extractMinIndex();
            assert (edgeTo[v] != null);
            mst.add(edgeTo[v]);
            visit(v);
        }

        mstWeight = mst.elementAt(0).wt();
        for (int i = 0; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }
    }

    private void visit(int v) {

        assert !marked[v];
        marked[v] = true;

        for (Object item : G.adj(v)) {
            Edge<Weight> e = (Edge<Weight>) item;
            int w = e.other(v);
            if (!marked[w]) {
                if (edgeTo[w] == null) {
                    edgeTo[w] = e;
                    iqp.insert(w, e.wt());
                }
            } else if (e.wt().compareTo(edgeTo[w].wt()) < 0) {
                edgeTo[w] = e;
                iqp.change(w, e.wt());
            }
        }
    }

    // 返回最小生成树的所有边
    Vector<Edge<Weight>> mstEdges(){
        return mst;
    }

    // 返回最小生成树的权值
    Number result(){
        return mstWeight;
    }

}
