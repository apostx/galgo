package galgo.graph;

import org.junit.Before;

public class VertexMatrixTest extends GraphTestCore {
    
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
}
