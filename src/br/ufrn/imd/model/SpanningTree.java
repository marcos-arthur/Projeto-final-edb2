package br.ufrn.imd.model;

import java.util.ArrayList;
import java.util.List;

public class SpanningTree extends Graph{
    ArrayList<Edge> spanningTree;
    ArrayList<Edge> includedEdges;
    ArrayList<Edge> excludedEdges;

    /**
     * -1 - excluded
     *  0 - open
     *  1 - included
     */
    ArrayList<int[][]> edgeStatus;

    int totalCost;

    public SpanningTree(Graph originalGraph, ArrayList<Edge> spanningTree, int totalCost) {
        super(originalGraph.getNodes(), originalGraph.getEdges());
        this.spanningTree = spanningTree;
        this.totalCost = totalCost;
    }

    public ArrayList<Edge> getSpanningTree() {
        return spanningTree;
    }

    public void setSpanningTree(ArrayList<Edge> spanningTree) {
        this.spanningTree = spanningTree;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public ArrayList<Edge> getIncludedEdges() {
        return includedEdges;
    }

    public void setIncludedEdges(ArrayList<Edge> includedEdges) {
        this.includedEdges = includedEdges;
    }

    public ArrayList<Edge> getExcludedEdges() {
        return excludedEdges;
    }

    public void setExcludedEdges(ArrayList<Edge> excludedEdges) {
        this.excludedEdges = excludedEdges;
    }

    public void partition(){
        edgeStatus = new ArrayList<>();
        // nodes.size() - 1 == spanningTree.size()
        for (int i = 0; i < nodes.size() - 1; i++){
            edgeStatus.add(new int[nodes.size() - 1][2]);
            for (int j = 0; j < i + 1; j++){
                if(j == i) edgeStatus.get(i)[j][1] = -1;
                else edgeStatus.get(i)[j][1] = 1;
            }
        }
    }
}
