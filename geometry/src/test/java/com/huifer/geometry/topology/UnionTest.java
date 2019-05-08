package com.huifer.geometry.topology;

import static com.huifer.geometry.topology.Union.union;

import com.esri.core.geometry.Envelope;
import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.MultiPath;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Union Tester.
 *
 * @author huifer
 */
public class UnionTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: union(Geometry[] geomArray)
     */
    @Test
    public void testUnion() throws Exception {
        Envelope env = new Envelope(1, 5, 3, 10);

        Polygon polygon = new Polygon();
        polygon.startPath(new Point(4, 3));
        polygon.lineTo(new Point(7, 6));
        polygon.lineTo(new Point(6, 8));
        polygon.lineTo(new Point(4, 3));

        Geometry[] geomArray = new Geometry[]{env, polygon};
        MultiPath union = union(geomArray);
        System.out.println(union);
    }


}
