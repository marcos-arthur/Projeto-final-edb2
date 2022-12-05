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
        ArrayList<Integer> checkLimitArray = new ArrayList<>();

        for (int i = 0; i < numberOfNodes; ++i){
            minorTree.addElement(i);
            checkLimitArray.add(0);
        }

        graph.sortEdgesByCost();

        for (Edge edge : graph.getEdges()){
            if (checkLimitArray.get(edge.getCurrent()) < limitConnections && checkLimitArray.get(edge.getTarget()) < limitConnections){
                if(!minorTree.inSameSet(edge.getCurrent(), edge.getTarget())){
                    minorTree.union(edge.getCurrent(), edge.getTarget());
                    minorTreeEdges.add(edge);
                    checkLimitArray.set(edge.getCurrent(), checkLimitArray.get(edge.getCurrent()) + 1);
                    checkLimitArray.set(edge.getTarget(), checkLimitArray.get(edge.getTarget()) + 1);
                }
            }
        }

        return minorTreeEdges;
    }

}
