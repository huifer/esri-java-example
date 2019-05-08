package com.huifer.geometry.utils;

import com.esri.core.geometry.Envelope2D;
import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.GeometryCursor;
import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Operator;
import com.esri.core.geometry.OperatorClip;
import com.esri.core.geometry.OperatorFactoryLocal;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.SimpleGeometryCursor;
import com.esri.core.geometry.SpatialReference;

/**
 * <p>Title : Clip </p>
 * <p>Description : clip</p>
 *
 * @author huifer
 * @date 2019-05-08
 */
public class Clip {

    public static final OperatorFactoryLocal engine = OperatorFactoryLocal.getInstance();
    public static final  OperatorClip clipOp = (OperatorClip) engine.getOperator(Operator.Type.Clip);


    /**
     * clip polygon
     *
     * @param polygon polygon
     * @param envelope2D envelope
     * @param spatialReference spatialReference
     * @return geom
     */
    public static Geometry clipPolygon(Polygon polygon, Envelope2D envelope2D,
            SpatialReference spatialReference) {
        SimpleGeometryCursor polygonCurs = new SimpleGeometryCursor(polygon);

        GeometryCursor clipPolygonCurs = clipOp.execute(polygonCurs, envelope2D,
                spatialReference, null);

        Polygon clippedPolygon = (Polygon) clipPolygonCurs.next();

        return clippedPolygon;
    }

    /**
     * clip Polyline
     *
     * @param polyline polyline
     * @param envelope2D envelope
     * @param spatialReference spatialReference
     * @return geom
     */
    public static Geometry clipPolyline(Polyline polyline, Envelope2D envelope2D,
            SpatialReference spatialReference) {
        SimpleGeometryCursor polylineCurs = new SimpleGeometryCursor(polyline);

        GeometryCursor clipPolygonCurs = clipOp.execute(polylineCurs, envelope2D,
                spatialReference, null);

        Polyline clippedPolyline = (Polyline) clipPolygonCurs.next();

        return clippedPolyline;
    }

    /**
     * clipMultiPoint
     *
     * @param multiPoint multiPoint
     * @param envelope2D envelope
     * @param spatialReference spatialReference
     * @return geom
     */
    public static Geometry clipMultiPoint(MultiPoint multiPoint, Envelope2D envelope2D,
            SpatialReference spatialReference) {
        SimpleGeometryCursor multipointCurs = new SimpleGeometryCursor(
                multiPoint);
        GeometryCursor clipMultiPointCurs = clipOp.execute(multipointCurs,
                envelope2D, spatialReference, null);
        MultiPoint clippedMultiPoint = (MultiPoint) clipMultiPointCurs.next();
        return clippedMultiPoint;
    }

    /**
     * clipPoint
     *
     * @param point point
     * @param envelope2D envelope
     * @param spatialReference spatialReference
     * @return geom
     */
    public static Geometry clipPoint(Point point, Envelope2D envelope2D,
            SpatialReference spatialReference) {
        SimpleGeometryCursor pointCurs = new SimpleGeometryCursor(point);
        GeometryCursor clipPointCurs = clipOp.execute(pointCurs, envelope2D,
                spatialReference, null);
        Point clippedPoint = (Point) clipPointCurs.next();
        return clippedPoint;
    }

    /**
     * clip geometry
     *
     * @param geometry geometry
     * @param envelope2D envelope
     * @param spatialReference spatialReference
     * @return geom
     */
    public static Geometry clipGeometry(Geometry geometry, Envelope2D envelope2D,
            SpatialReference spatialReference) {
        if (geometry instanceof Point) {
            return clipPoint((Point) geometry, envelope2D, spatialReference);
        }
        if (geometry instanceof MultiPoint) {
            return clipMultiPoint((MultiPoint) geometry, envelope2D, spatialReference);
        }
        if (geometry instanceof Polyline) {
            return clipPolyline((Polyline) geometry, envelope2D, spatialReference);
        }
        if (geometry instanceof Polygon) {
            return clipPolygon((Polygon) geometry, envelope2D, spatialReference);
        } else {
            return null;
        }
    }
}
