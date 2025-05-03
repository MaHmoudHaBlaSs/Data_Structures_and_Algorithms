// This class is used only in priority queue as pair of (graph node itself and the min cost it has uptill now)
class Node implements Comparable<Node> {
    int vertex;
    int cost;
    public Node (int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other){
        return Integer.compare(this.cost, other.cost);
    }
}