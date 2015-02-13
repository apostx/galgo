package galgo.graph;

public class Algorithms {
    
    /**
     * http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
     * 
     * @param graph
     * @param source It's index of start vertex in graph
     * @param dist Its length must be equal to number of edges of graph!
     * @param prev Its length must be equal to number of edges of graph!
     */
    
    static public void dijkstra(IGraph graph,int source,float[] dist,int[] prev) {
        int vertexNum = graph.getVertexNum();

        int[] Q = new int[vertexNum];
        
        dijkstra(graph,source,dist,prev,Q);
    }
    
    static public void dijkstra(IGraph Graph,int source,float[] dist,int[] prev,int[] Q) {
        dist[source] = 0;
        prev[source] = -1;
        
        int vertexNum = Graph.getVertexNum();
        int QSize = vertexNum;
        Q[0] = source;
        
        for(int u = 0;u < vertexNum; ++u) {
            Q[u] = u;
            prev[u] = -1;

            if (source != u)
                dist[u] = Float.POSITIVE_INFINITY;
        }
        
        
        float alt;
        float minDist;
        int distIndex;
        int minQIndex;
        float curDist;
        for (int u;0<QSize;--QSize) {
            
            minQIndex = 0;
            u = distIndex = Q[0];
            minDist = dist[distIndex];
            for (int i = 1; i < QSize; ++i) {
                distIndex = Q[i];
                curDist = dist[distIndex];
                if (curDist < minDist) {
                    minDist = curDist;
                    u = distIndex;
                    minQIndex = i;
                }
            }
            
            System.arraycopy(Q, minQIndex+1, Q, minQIndex, Q.length-1-minQIndex);
            
            for (int v : Graph.getNeighbors(u)) {
                alt = Graph.getEdge(u,v)+dist[u];

                if (alt < dist[v]) {
                   dist[v] = alt;
                   prev[v] = u;
                }
            }
        }
    }
}
