package com.huifer.geometry.utils;

import com.esri.core.geometry.Envelope;
import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.Line;
import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Operator;
import com.esri.core.geometry.OperatorBuffer;
import com.esri.core.geometry.OperatorFactoryLocal;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.SpatialReference;

/**
 * <p>Title : Buffer </p>
 * <p>Description : </p>
 *
 * @author huifer
 * @date 2019-05-08
 */
public class Buffer {

    public static final OperatorBuffer buffer = (OperatorBuffer) OperatorFactoryLocal.getInstance()
            .getOperator(Operator.Type.Buffer);

    /**
     * geometry 的缓冲区
     *
     * @param geometry geometry
     * @param sr 坐标系
     * @param distance 缓冲距离
     * @return 缓冲区
     */
    static Geometry geometryBuffer(Geometry geometry, SpatialReference sr, double distance) {
        if (geometry instanceof Point) {
            return pointBuffer((Point) geometry, sr, distance);
        }
        if (geometry instanceof MultiPoint) {
            return multiPointBuffer((MultiPoint) geometry, sr, distance);
        }
        if (geometry instanceof Polyline) {
            return polylineBuffer((Polyline) geometry, sr, distance);
        }
        if (geometry instanceof Polygon) {
            return polygonBuffer((Polygon) geometry, sr, distance);
        }
        if (geometry instanceof Envelope) {
            return envelopeBuffer((Envelope) geometry, sr, distance);
        } else {
            return null;
        }
    }

    /**
     * point 的缓冲区
     *
     * @param point point
     * @param sr 坐标系
     * @param distance 缓冲距离
     * @return 缓冲区
     */
    static Geometry pointBuffer(Point point, SpatialReference sr, double distance) {
        Geometry result = buffer.execute(point, sr, distance, null);
        return result;
    }

    /**
     * envelope 的缓冲区
     *
     * @param envelope envelope
     * @param sr 坐标系
     * @param distance 缓冲距离
     * @return 缓冲区
     */
    static Geometry envelopeBuffer(Envelope envelope, SpatialReference sr, double distance) {
        Geometry result = buffer.execute(envelope, sr, distance, null);
        return result;
    }

    /**
     * multiPoint 的缓冲区
     *
     * @param multiPoint multiPoint
     * @param sr 坐标系
     * @param distance 缓冲距离
     * @return 缓冲区
     */
    static Geometry multiPointBuffer(MultiPoint multiPoint, SpatialReference sr, double distance) {
        Geometry result = buffer.execute(multiPoint, sr, distance, null);
        return result;
    }

    /**
     * line 的缓冲区
     *
     * @param line line
     * @param sr 坐标系
     * @param distance 缓冲距离
     * @return 缓冲区
     */
    static Geometry lineBuffer(Line line, SpatialReference sr, double distance) {
        Geometry result = buffer.execute(line, sr, distance, null);
        return result;
    }

    /**
     * polyline 的缓冲区
     *
     * @param polyline polyline
     * @param sr 坐标系
     * @param distance 缓冲距离
     * @return 缓冲区
     */
    static Geometry polylineBuffer(Polyline polyline, SpatialReference sr, double distance) {
        Geometry result = buffer.execute(polyline, sr, distance, null);
        return result;
    }

    /**
     * polygon的缓冲区
     *
     * @param polygon polygon
     * @param sr 坐标系
     * @param distance 缓冲距离
     * @return 缓冲区
     */
    static Geometry polygonBuffer(Polygon polygon, SpatialReference sr, double distance) {
        Geometry result = buffer.execute(polygon, sr, distance, null);
        return result;
    }

}
