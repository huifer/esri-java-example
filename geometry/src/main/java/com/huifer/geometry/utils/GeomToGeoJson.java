package com.huifer.geometry.utils;

import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Operator;
import com.esri.core.geometry.OperatorExportToGeoJson;
import com.esri.core.geometry.OperatorFactoryLocal;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.ogc.OGCLineString;
import com.esri.core.geometry.ogc.OGCMultiPoint;
import com.esri.core.geometry.ogc.OGCPoint;
import com.esri.core.geometry.ogc.OGCPolygon;

/**
 * <p>Title : GeomToGeoJson </p>
 * <p>Description : </p>
 *
 * @author huifer
 * @date 2019-05-08
 */
public class GeomToGeoJson {

    public static final OperatorFactoryLocal factory = OperatorFactoryLocal.getInstance();


    /**
     * multiPoint2GeoJson
     *
     * @param mp 多点
     * @return 多点的geojson
     */
    public static String multiPoint2GeoJson(MultiPoint mp) {
        OperatorExportToGeoJson exporter = (OperatorExportToGeoJson) factory
                .getOperator(Operator.Type.ExportToGeoJson);
        String result = exporter.execute(mp);
        return result;
    }

    /**
     * point2GeoJson
     *
     * @param p 点
     * @return 点的geojson
     */
    public static String point2GeoJson(Point p) {
        OperatorExportToGeoJson exporter = (OperatorExportToGeoJson) factory
                .getOperator(Operator.Type.ExportToGeoJson);
        String result = exporter.execute(p);
        return result;
    }

    /**
     * ogcPoint2GeoJson
     *
     * @param point ogcPoint
     * @return ogcPoint的geojson
     */
    public static String ogcPoint2GeoJson(OGCPoint point) {
        return point.asGeoJson();
    }

    /**
     * ogcMultiPoint2GeoJson
     *
     * @param ogcMultiPoint ogc多点
     * @return ogc多点的geojson
     */
    public static String ogcMultiPoint2GeoJson(OGCMultiPoint ogcMultiPoint) {
        return ogcMultiPoint.asGeoJson();
    }

    /**
     * polyline2GeoJson
     *
     * @param polyline polyline
     * @return polyline的geojson
     */
    public static String polyline2GeoJson(Polyline polyline) {
        OperatorExportToGeoJson exporter = (OperatorExportToGeoJson) factory
                .getOperator(Operator.Type.ExportToGeoJson);
        String result = exporter.execute(polyline);
        return result;
    }

    /**
     * ogcPolyline2GeoJson
     *
     * @param lineString lineString
     * @return lineString的geojson
     */
    public static String ogcPolyline2GeoJson(OGCLineString lineString) {
        return lineString.asGeoJson();
    }

    /**
     * polygon2GeoJson
     *
     * @param polygon polygon
     * @return polygon的geojson
     */
    public static String polygon2GeoJson(Polygon polygon) {
        OperatorExportToGeoJson exporter = (OperatorExportToGeoJson) factory
                .getOperator(Operator.Type.ExportToGeoJson);
        String result = exporter.execute(polygon);
        return result;
    }

    /**
     * ogcPolygon2GeoJson
     *
     * @param ogcPolygon ogcPolygon
     * @return ogcPolygon的geojson
     */
    public static String ogcPolygon2GeoJson(OGCPolygon ogcPolygon) {
        return ogcPolygon.asGeoJson();
    }


}
