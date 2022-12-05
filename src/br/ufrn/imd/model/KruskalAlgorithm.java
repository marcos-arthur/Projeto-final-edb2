package br.ufrn.imd.model;

import org.jgrapht.alg.util.UnionFind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class KruskalAlgorithm {
    Graph graph;
    int numberOfNodes;
    int limitConnections;

    public KruskalAlgorithm(Graph graph, int numberOfNodes, int limitConnections) {
        this.graph = graph;
        this.numberOfNodes = numberOfNodes;
        this.limitConnections = limitConnections;
    }

    public ArrayList<Edge> run(){
        Set<Integer> nodes = new HashSet<>();
        UnionFind<Integer> minorTree = new UnionFind<>(nodes);

        ArrayList<Edge> minorTreeEdges = new ArrayList<>();

        for (int i = 0; i < numberOfNodes; ++i){
            minorTree.addElement(i);
        }

        graph.sortEdgesByCost();

        for (Edge edge : graph.getEdges()){
            if(!minorTree.inSameSet(edge.getCurrent(), edge.getTarget())){
                minorTree.union(edge.getCurrent(), edge.getTarget());
                minorTreeEdges.add(edge);
            }
        }

        return minorTreeEdges;
    }

}
