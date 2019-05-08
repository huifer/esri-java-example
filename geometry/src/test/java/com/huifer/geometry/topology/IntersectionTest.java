package com.huifer.geometry.topology;

import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.SpatialReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Intersection Tester.
 *
 * @author ${USER}
 * @version 1.0
 * @since <pre>五月 8, 2019</pre>
 */
public class IntersectionTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }
    private static Polygon createPolygon(double[][] points) {
        Polygon pg = new Polygon();
        pg.startPath(points[0][0], points[0][1]);

        for (int i = 1; i < points.length; i++) {
            pg.lineTo(points[i][0], points[i][1]);
        }

        return pg;

    }

    private static Polyline createPolyline(double[][] points) {
        Polyline line = new Polyline();
        line.startPath(points[0][0], points[0][1]);

        for (int i = 1; i < points.length; i++) {
            line.lineTo(points[i][0], points[i][1]);
        }

        return line;
    }

    /**
     * Method: geomIntersection(Polygon polygon, Polyline polyline, SpatialReference sr)
     */
    @Test
    public void testGeomIntersection() throws Exception {
        double[][] polygon_coords = {{0, 4}, {2, 10}, {8, 12}, {12, 6}, {10, 2}, {4, 0}};
        Polygon polygon = createPolygon(polygon_coords);
        double[][] polyline_coords = {{1, 15}, {3.5, 10.5}, {6.5, 11.5}, {18, 11.5}};

        Polyline polyline = createPolyline(polyline_coords);
        SpatialReference sr = SpatialReference.create(4326);

        Intersection.geomIntersection(polygon, polyline, sr);

    }


}
