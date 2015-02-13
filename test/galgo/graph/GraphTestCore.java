package galgo.graph;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

@Ignore
public abstract class GraphTestCore {
    
    protected IGraph _normalGraph;
    protected IGraph _directedGraph;

    @Test
    public void testGetVertexNum() {
        assertEquals(5,_normalGraph.getVertexNum());
        assertEquals(5,_directedGraph.getVertexNum());
    }

    @Test
    public void testGetEdge() {
        assertEquals(10, _normalGraph.getEdge(0, 1),0);
        assertEquals(10, _normalGraph.getEdge(1, 0),0);
        
        assertEquals(10, _directedGraph.getEdge(0, 1),0);
        assertEquals(Float.POSITIVE_INFINITY,_directedGraph.getEdge(1, 0),0);
    }

    @Test
    public void testGetNeighbors() {
        assertArrayEquals(new int[]{0,4},_normalGraph.getNeighbors(3));
        assertArrayEquals(new int[]{1,2,4},_directedGraph.getNeighbors(3));
    }
}
