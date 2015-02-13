package galgo.graph;

public interface IGraph {
    int getVertexNum();
    float getEdge(int sourceVertex,int targetVertex);
    int[] getNeighbors(int vertex);
}
