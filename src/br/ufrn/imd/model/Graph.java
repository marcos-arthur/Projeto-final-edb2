package br.ufrn.imd.model;

import org.jgrapht.alg.util.UnionFind;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Node> nodes;
    List<Edge> edges;
    ArrayList<Edge> minorTree;

    public Graph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public void initializeGraph(int nodeQuantity){
        for(int i = 0; i < nodeQuantity; i++){
            nodes.add(new Node(i));
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public ArrayList<Edge> getMinorTree() {
        return minorTree;
    }

    public void setMinorTree(ArrayList<Edge> minorTree) {
        this.minorTree = minorTree;
    }

    public void addNode(int n){
        nodes.add(new Node(n));
    }

    public void addEdge(int nodeId, int nodeTargetId, int cost){
        edges.add(new Edge(nodeId, nodeTargetId, cost));
    }

    public void sortEdgesByCost(){
        edges.sort(new SortEdge());
    }

    public void printEdges(){
        int count = 0;
        for (int i = 0; i < nodes.size(); ++i){
            for (int j = 0; j < i; ++j){
                System.out.print(edges.get(count) + " ");
                count++;
            }
            System.out.println("");
        }
    }

    public void printMinorTree(){
        System.out.println(minorTree);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
