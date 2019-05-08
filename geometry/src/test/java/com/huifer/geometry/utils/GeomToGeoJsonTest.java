package com.huifer.geometry.utils;

import static org.junit.Assert.assertEquals;

import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.ogc.OGCLineString;
import com.esri.core.geometry.ogc.OGCMultiPoint;
import com.esri.core.geometry.ogc.OGCPoint;
import com.esri.core.geometry.ogc.OGCPolygon;

public class GeomToGeoJsonTest {


    @org.junit.Test
    public void point2GeoJson() {
        Point point = new Point(0, 0);
        String s = GeomToGeoJson.point2GeoJson(point);
        assertEquals("{\"type\":\"Point\",\"coordinates\":[0,0]}", s);
        point = new Point();
        s = GeomToGeoJson.point2GeoJson(point);
        assertEquals("{\"type\":\"Point\",\"coordinates\":[]}", s);


    }

    @org.junit.Test
    public void ogcPoint2GeoJson() {

        Point point = new Point(0, 0);
        OGCPoint ogcPoint = new OGCPoint(point, null);
        String s = GeomToGeoJson.ogcPoint2GeoJson(ogcPoint);
        assertEquals("{\"type\":\"Point\",\"coordinates\":[0,0],\"crs\":null}", s);
        point = new Point();
        ogcPoint = new OGCPoint(point, null);
        s = GeomToGeoJson.ogcPoint2GeoJson(ogcPoint);
        assertEquals("{\"type\":\"Point\",\"coordinates\":[],\"crs\":null}", s);

    }

    @org.junit.Test
    public void multiPoint2GeoJson() {
        MultiPoint mp = new MultiPoint();
        mp.add(0, 0);
        mp.add(1, 1);
        String s = GeomToGeoJson.multiPoint2GeoJson(mp);
        assertEquals("{\"type\":\"MultiPoint\",\"coordinates\":[[0,0],[1,1]]}", s);
        mp = new MultiPoint();
        s = GeomToGeoJson.multiPoint2GeoJson(mp);
        assertEquals("{\"type\":\"MultiPoint\",\"coordinates\":[]}", s);


    }

    @org.junit.Test
    public void ogcMultiPoint2GeoJson() {
        MultiPoint mp = new MultiPoint();
        mp.add(0, 0);
        mp.add(1, 1);
        OGCMultiPoint ogcMultiPoint = new OGCMultiPoint(mp, null);
        String s = GeomToGeoJson.ogcMultiPoint2GeoJson(ogcMultiPoint);
        assertEquals("{\"type\":\"MultiPoint\",\"coordinates\":[[0,0],[1,1]],\"crs\":null}", s);
        mp = new MultiPoint();
        ogcMultiPoint = new OGCMultiPoint(mp, null);
        s = GeomToGeoJson.ogcMultiPoint2GeoJson(ogcMultiPoint);
        assertEquals("{\"type\":\"MultiPoint\",\"coordinates\":[],\"crs\":null}", s);
    }

    @org.junit.Test
    public void polyline2GeoJson() {
        Polyline polyline = new Polyline();
        polyline.startPath(0, 0);
        polyline.lineTo(1, 1);
        String s = GeomToGeoJson.polyline2GeoJson(polyline);
        assertEquals("{\"type\":\"LineString\",\"coordinates\":[[0,0],[1,1]]}", s);
        polyline = new Polyline();
        s = GeomToGeoJson.polyline2GeoJson(polyline);
        assertEquals("{\"type\":\"LineString\",\"coordinates\":[]}", s);
    }

    @org.junit.Test
    public void ogcPolyline2GeoJson() {
        Polyline polyline = new Polyline();
        polyline.startPath(0, 0);
        polyline.lineTo(1, 1);
        OGCLineString lineString = new OGCLineString(polyline, 0, null);
        String s = GeomToGeoJson.ogcPolyline2GeoJson(lineString);
        assertEquals("{\"type\":\"LineString\",\"coordinates\":[[0,0],[1,1]],\"crs\":null}", s);
    }

    @org.junit.Test
    public void polygon2GeoJson() {
        Polygon polygon = new Polygon();

        polygon.startPath(0, 0);
        polygon.lineTo(1, 1);
        polygon.lineTo(2, 31);
        polygon.closePathWithLine();

        String s = GeomToGeoJson.polygon2GeoJson(polygon);
        assertEquals("{\"type\":\"Polygon\",\"coordinates\":[[[0,0],[2,31],[1,1],[0,0]]]}",s);
        polygon = new Polygon();
        s = GeomToGeoJson.polygon2GeoJson(polygon);
        assertEquals("{\"type\":\"Polygon\",\"coordinates\":[]}",s);
    }

    @org.junit.Test
    public void ogcPolygon2GeoJson() {
        Polygon polygon = new Polygon();

        polygon.startPath(0, 0);
        polygon.lineTo(1, 1);
        polygon.lineTo(2, 31);
        polygon.closePathWithLine();
        OGCPolygon ogcMultiPolygon = new OGCPolygon(polygon, null);

        String s = GeomToGeoJson.ogcPolygon2GeoJson(ogcMultiPolygon);
        assertEquals("{\"type\":\"Polygon\",\"coordinates\":[[[0,0],[2,31],[1,1],[0,0]]],\"crs\":null}",s);
    }
}
