package galgo.graph;

import static galgo.graph.Algorithms.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AlgorithmsTest {
    
    private IGraph _normalGraph;
    private IGraph _directedGraph;

    @Before
    public void setUp() {
        float[][] testMatrix = new float[][]{
            {Float.POSITIVE_INFINITY,10,Float.POSITIVE_INFINITY,5,Float.POSITIVE_INFINITY},
            {Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,1,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY},
            {Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,1},
            {Float.POSITIVE_INFINITY,3,9,Float.POSITIVE_INFINITY,11},
            {Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY}};
        
        _normalGraph = new VertexMatrix(testMatrix,false);
        _directedGraph = new VertexMatrix(testMatrix,true);
    }
    
    @Test
    public void testDijkstra() {
        int source = 0;
        int length = _normalGraph.getVertexNum();
        float[] dist = new float[length];
        int[] prev = new int[length];
        
        dijkstra(_normalGraph,source,dist,prev);

        assertArrayEquals(new float[]{0,10,11,5,12},dist,0);
        assertArrayEquals(new int[]{-1,0,1,0,2},prev);
        
        dijkstra(_directedGraph,source,dist,prev);

        assertArrayEquals(new float[]{0,8,9,5,10},dist,0);
        assertArrayEquals(new int[]{-1,3,1,0,2},prev);
    }
}
