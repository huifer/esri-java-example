package com.huifer.geometry.utils;

import static com.huifer.geometry.utils.CreateTestData.makeEnvelope;
import static com.huifer.geometry.utils.CreateTestData.makeLine;
import static com.huifer.geometry.utils.CreateTestData.makeMultiPoint;
import static com.huifer.geometry.utils.CreateTestData.makePoint;
import static com.huifer.geometry.utils.CreateTestData.makePolygon;
import static com.huifer.geometry.utils.CreateTestData.makePolyline;

import com.esri.core.geometry.Envelope;
import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.Line;
import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Buffer Tester.
 *
 * @author huifer
 */
public class BufferTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: pointBuffer(Point point, SpatialReference sr, double distance)
     */
    @Test
    public void testPointBuffer() throws Exception {
        Point point = makePoint();
        Geometry geometry = Buffer.pointBuffer(point, null, 10);
        System.out.println(geometry);

    }

    /**
     * Method: envelopeBuffer(Envelope envelope, SpatialReference sr, double distance)
     */
    @Test
    public void testEnvelopeBuffer() throws Exception {
        Envelope envelope = makeEnvelope();
        Geometry geometry = Buffer.envelopeBuffer(envelope, null, 10);
        System.out.println(geometry);

    }

    /**
     * Method: multiPointBuffer(MultiPoint mp, SpatialReference sr, double distance)
     */
    @Test
    public void testMultiPointBuffer() throws Exception {
        MultiPoint multiPoint = makeMultiPoint();
        Geometry geometry = Buffer.multiPointBuffer(multiPoint, null, 10);
        System.out.println(geometry);

    }

    /**
     * Method: lineBuffer(Line line, SpatialReference sr, double distance)
     */
    @Test
    public void testLineBuffer() throws Exception {

        Line line = makeLine();
        Geometry geometry = Buffer.lineBuffer(line, null, 10);
        System.out.println(geometry);
    }

    /**
     * Method: polylineBuffer(Polyline polyline, SpatialReference sr, double distance)
     */
    @Test
    public void testPolylineBuffer() throws Exception {
        Polyline polyline = makePolyline();
        Geometry geometry = Buffer.polylineBuffer(polyline, null, 10);
        System.out.println(geometry);
    }

    /**
     * Method: polygonBuffer(Polygon polygon, SpatialReference sr, double distance)
     */
    @Test
    public void testPolygonBuffer() throws Exception {
        Polygon polygon = makePolygon();
        Geometry geometry = Buffer.polygonBuffer(polygon, null, 10);
        System.out.println(geometry);
    }


}
