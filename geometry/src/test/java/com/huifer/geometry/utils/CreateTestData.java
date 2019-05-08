package com.huifer.geometry.utils;

import com.esri.core.geometry.Envelope;
import com.esri.core.geometry.Line;
import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Point2D;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;

/**
 * <p>Title : CreateTestData </p>
 * <p>Description : </p>
 *
 * @author huifer
 * @date 2019-05-08
 */
public class CreateTestData {

    public static Polygon makePolygon() {
        Polygon poly = new Polygon();
        poly.startPath(0, 0);
        poly.lineTo(10, 10);
        poly.lineTo(20, 0);

        return poly;
    }

    public static Polyline makePolyline() {
        Polyline poly = new Polyline();
        poly.startPath(0, 0);
        poly.lineTo(10, 10);
        poly.lineTo(20, 0);

        return poly;
    }

    public static Line makeLine() {
        return new Line(12, 120, 20, 120);
    }

    public static MultiPoint makeMultiPoint() {
        MultiPoint mpoint = new MultiPoint();

        Point2D pt1 = new Point2D();
        pt1.x = 10;
        pt1.y = 10;

        Point2D pt2 = new Point2D();
        pt2.x = 15;
        pt2.y = 10;

        Point2D pt3 = new Point2D();
        pt3.x = 10;
        pt3.y = 20;

        mpoint.add(pt1.x, pt1.y);
        mpoint.add(pt2.x, pt2.y);
        mpoint.add(pt3.x, pt3.y);

        return mpoint;
    }

    public static Point makePoint() {
        Point point = new Point();

        Point2D pt = new Point2D();
        pt.setCoords(10, 20);
        point.setXY(pt);

        return point;
    }

    public static Envelope makeEnvelope() {
        Envelope envelope = new Envelope(1, 0, 200, 400);
        return envelope;
    }

}
