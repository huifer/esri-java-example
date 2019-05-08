package com.huifer.geometry.utils;

import static com.huifer.geometry.utils.CreateTestData.makeMultiPoint;
import static com.huifer.geometry.utils.CreateTestData.makePoint;
import static com.huifer.geometry.utils.CreateTestData.makePolygon;
import static com.huifer.geometry.utils.CreateTestData.makePolyline;

import com.esri.core.geometry.Envelope2D;
import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clip Tester.
 *
 * @author huifer
 */
public class ClipTest {

    private Envelope2D envelope = new Envelope2D();



    @Before
    public void before() throws Exception {
        envelope.xmin = 0;
        envelope.xmax = 20;
        envelope.ymin = 5;
        envelope.ymax = 15;
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: clipPolygon(Polygon polygon, Envelope2D envelope2D, SpatialReference
     * spatialReference)
     */
    @Test
    public void testClipPolygon() throws Exception {
        Polygon polygon = makePolygon();
        Geometry geometry = Clip.clipPolygon(polygon, this.envelope, null);
        System.out.println(geometry);
    }

    /**
     * Method: clipPolyline(Polyline polyline, Envelope2D envelope2D, SpatialReference
     * spatialReference)
     */
    @Test
    public void testClipPolyline() throws Exception {
        Polyline polyline = makePolyline();
        Geometry geometry = Clip.clipPolyline(polyline, envelope, null);
        System.out.println(geometry);
    }

    /**
     * Method: clipMultiPoint(MultiPoint multiPoint, Envelope2D envelope2D, SpatialReference
     * spatialReference)
     */
    @Test
    public void testClipMultiPoint() throws Exception {
        MultiPoint multiPoint = makeMultiPoint();
        Geometry geometry = Clip.clipMultiPoint(multiPoint, envelope, null);
        System.out.println(geometry);
    }

    /**
     * Method: clipPoint(Point point, Envelope2D envelope2D, SpatialReference spatialReference)
     */
    @Test
    public void testClipPoint() throws Exception {
        Point point = makePoint();
        Geometry geometry = Clip.clipPoint(point, envelope, null);
        System.out.println(geometry);
    }


}
