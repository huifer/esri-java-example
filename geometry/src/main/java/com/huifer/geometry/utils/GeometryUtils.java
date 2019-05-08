package com.huifer.geometry.utils;

import com.esri.core.geometry.Envelope;
import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.GeometryEngine;
import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.SpatialReference;

/**
 * <p>Title : GeometryUtils </p>
 * <p>Description : 几何工具</p>
 *
 * @author huifer
 * @date 2019-05-08
 */
public class GeometryUtils {

    static String getGeometryType(Geometry geometry) {
        if (geometry instanceof Point) {
            return "esriGeometryPoint";
        }
        if (geometry instanceof MultiPoint) {
            return "esriGeometryMultipoint";
        }
        if (geometry instanceof Polyline) {
            return "esriGeometryPolyline";
        }
        if (geometry instanceof Polygon) {
            return "esriGeometryPolygon";
        }
        if (geometry instanceof Envelope) {
            return "esriGeometryEnvelope";
        } else {
            return null;
        }
    }

    static Geometry getGeometryFromJSon(String jsonStr) {
        try {
            Geometry geom = GeometryEngine.jsonToGeometry(jsonStr).getGeometry();
            return geom;
        } catch (Exception ex) {
            return null;
        }
    }

    static String getJSonStringFromGeometry(Geometry geomIn, SpatialReference sr) {
        String jsonStr4Geom = GeometryEngine.geometryToJson(sr, geomIn);
        String jsonStrNew = "{\"geometryType\":\"" + getGeometryType(geomIn)
                + "\",\"geometries\":[" + jsonStr4Geom + "]}";
        return jsonStrNew;
    }

}
