package br.ufrn.imd.model;

import java.util.List;

public class Graph {
    List<Node> nodes;
    List<Edge> edges;

    public Graph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
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

    public void addNode(int n){
        nodes.add(new Node(n));
    }

    public void addEdge(int nodeId, int nodeTargetId, int cost){
        edges.add(new Edge(nodeId, nodeTargetId, cost));
    }

    public void initializeGraph(int nodeQuantity){
        for(int i = 0; i < nodeQuantity; i++){
            nodes.add(new Node(i));
        }
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

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
