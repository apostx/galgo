package galgo.graph;

import java.util.Arrays;

public class VertexMatrix implements IGraph{

    private final float[][] _g;
    private final boolean _d;
    
    public VertexMatrix(float[][] graph,boolean directed) {
        _g = graph;
        _d = directed;
    }
    
    @Override
    public int getVertexNum() {
        return _g.length;
    }

    @Override
    public float getEdge(int sourceVertex, int targetVertex) {
        return (!_d && targetVertex < sourceVertex) ? _g[targetVertex][sourceVertex] : _g[sourceVertex][targetVertex]; 
    }

    @Override
    public int[] getNeighbors(int vertex) {
        int length = _g.length;
        int[] neighbors = new int[length-1];
        int count = 0;

        if (!_d)
            for(int i = 0; i < vertex ; ++i)
                if (Math.abs(_g[i][vertex]) < Float.POSITIVE_INFINITY)
                    neighbors[count++] = i;
        
        for(int i = !_d ? (vertex + 1):0; i < length ; ++i)
            if (_g[vertex][i] < Float.POSITIVE_INFINITY)
                neighbors[count++] = i;

        neighbors = Arrays.copyOf(neighbors, count);
        
        return neighbors;
    }
}
