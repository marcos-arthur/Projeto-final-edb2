package br.ufrn.imd.view;

import br.ufrn.imd.model.*;
import org.jgrapht.alg.util.UnionFind;

import java.util.*;

public class view {

    public void kruskalAlgo(Graph graph, int numberOfNodes, int limitConnetions) {
        Set<Integer> nodes = new HashSet<>();
        UnionFind<Integer> disjointSet = new UnionFind<>(nodes);

        // result = []

        for (int i = 1; i <= numberOfNodes; ++i){
            disjointSet.addElement(i);
        }

        graph.sortEdgesByCost();

        for (Edge edge : graph.getEdges()){
            System.out.println(disjointSet.inSameSet(edge.getCurrent(), edge.getTarget()));
        }


    }

    public static void main(String[] args) {
//        System.out.println("Hello World");

//
//        int [][] matrixCusto = new int[5][5];
//
//        Set<Integer> s = new HashSet<>();
//        UnionFind<Integer> uf = new UnionFind<>(s);
//
//        uf.addElement(1);
//        uf.addElement(3);
//        uf.addElement(4);
//
//        uf.union(1,3);
//
//        System.out.println(uf.toString());

//        for (int i = 0; i < 5; ++i){
//            for (int j = 0; j < 5; ++j){
//                matrixCusto[i][j] = (int) (Math.random() * 25);
//            }
//        }

        /**
         * n - Número de vértices / casas / nós
         * d - Limite de conexões de um vértice
         */
        int d, n;
        Graph links = new Graph(new ArrayList<>(), new ArrayList<>());
        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();

        d = sc.nextInt();

        links.initializeGraph(n);

        for (int i = 0; i < n; ++i){
            for (int j = i+1; j < n ; ++j){
                links.addEdge(i, j, sc.nextInt());
            }
        }

//        links.sortEdgesByCost();

//        links.printEdges();

        KruskalAlgorithm ka = new KruskalAlgorithm();

        // Stage 0
        SpanningTree st = ka.run(links, n, d);
        links.setMinorTree(st.getSpanningTree());
        links.addSpanningTree(st);


//        System.out.println(st.getTotalCost());


        // Stage 1



        links.printMinorTree();

    }
}
