package br.ufrn.imd.model;

public class Edge {
    int current;
    int target;
    int cost;

    public Edge(int current, int target, int cost) {
        this.current = current;
        this.target = target;
        this.cost = cost;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "current=" + current +
                ", target=" + target +
                ", cost=" + cost +
                '}';
    }
}
