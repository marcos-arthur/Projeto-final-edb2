package br.ufrn.imd.view;

import br.ufrn.imd.model.Edge;
import br.ufrn.imd.model.Graph;
import br.ufrn.imd.model.SortEdge;
import org.jgrapht.alg.util.UnionFind;

import java.util.*;

public class view {

    public void kruskalAlgo(ListIterator<Edge> graph, int limitConnetions) {
        Set<Integer> nodes = new HashSet<>();
        UnionFind<Integer> disjointSet = new UnionFind<>(nodes);

        // TODO: desenvolver lógica do kruskal


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

        int d, n;
        List<Edge> edges = new ArrayList<>();

        Graph links = new Graph(new ArrayList<>(), new ArrayList<>());

        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();

        links.initializeGraph(n);

        for (int i = 0; i < n; ++i){
            for (int j = 0; j < i; ++j){
                links.addEdge(i, j, sc.nextInt());
            }
        }

        links.sortEdgesByCost();

        links.printEdges();


    }
}
