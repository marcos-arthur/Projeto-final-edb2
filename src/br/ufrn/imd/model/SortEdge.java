package br.ufrn.imd.model;

import java.util.Comparator;

public class SortEdge implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        int value = 0;
        if(o1.getCost() < o2.getCost()) value = -1;
        else if (o1.getCost() > o2.getCost()) value = 1;

        return value;
    }
}
