package com.huifer.geometry.utils;

import static com.huifer.geometry.utils.CreateTestData.makeMultiPoint;
import static com.huifer.geometry.utils.CreateTestData.makePolygon;

import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Polygon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ConvexHull Tester.
 *
 * @author huifer
 */
public class ConvexHullTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: geometryConvexHull(Geometry geometry)
     */
    @Test
    public void testGeometryConvexHull() throws Exception {
        MultiPoint multiPoint = makeMultiPoint();
        Geometry geometry = ConvexHull.geometryConvexHull(multiPoint);
        System.out.println(geometry);

        Polygon polygon = makePolygon();
        geometry = ConvexHull.geometryConvexHull(polygon);
        System.out.println(geometry);

    }


}
