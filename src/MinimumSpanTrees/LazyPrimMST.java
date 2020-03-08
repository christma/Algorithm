package MinimumSpanTrees;

import java.util.Vector;

public class LazyPrimMST<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> G;
    private MinHeap<Edge<Weight>> pq;
    private boolean[] marked;
    private Vector<Edge<Weight>> mst;
    private Number mstWeight;


    public LazyPrimMST(WeightedGraph<Weight> graph) {
        G = graph;
        pq = new MinHeap<>(G.E());
        marked = new boolean[G.V()];
        mst = new Vector<>();

        visit(0);
        while (!pq.isEmpty()) {
            Edge<Weight> e = pq.extractMin();
            if (marked[e.v()] == marked[e.w()]) {
                continue;
            }
            mst.add(e);

            if (!marked[e.v()]) {
                visit(e.v());
            } else {
                visit(e.w());
            }

        }

        mstWeight = mst.elementAt(0).wt();
        for (int i = 0; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }


    }

    private void visit(int v) {

        assert !marked[v];
        marked[v] = true;

        for (Edge<Weight> e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    // 返回最小生成树的所有边
    Vector<Edge<Weight>> mstEdges(){
        return mst;

    };

    // 返回最小生成树的权值
    Number result(){
        return mstWeight;
    };
}
