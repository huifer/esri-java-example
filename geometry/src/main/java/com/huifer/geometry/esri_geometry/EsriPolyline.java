package com.huifer.geometry.esri_geometry;

import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.Geometry.Type;
import com.esri.core.geometry.MapGeometry;
import com.esri.core.geometry.OperatorImportFromGeoJson;
import com.esri.core.geometry.OperatorImportFromJson;
import com.esri.core.geometry.OperatorImportFromWkt;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.WktImportFlags;

/**
 * <p>Title : EsriPolyline </p>
 * <p>Description : Polyline</p>
 *
 * @author huifer
 * @date 2019-05-07
 */
public class EsriPolyline {

    public static void main(String[] args) {
        methodCreatePolyline();

        createPolylineFromJson();
        createPolylineFromGeojson();
        createPolylineFromWKT();

    }

    private static void createPolylineFromWKT() {
        String plWKT = "MULTILINESTRING ((120 30 , 121 31),(121 32,122 33))";
        Geometry geom = OperatorImportFromWkt
                .local().execute(WktImportFlags.wktImportDefaults, Type.Polyline, plWKT, null);
        Polyline geometry = (Polyline) geom;
        System.out.println(geometry);
    }

    private static void createPolylineFromGeojson() {
        //language=JSON
        String plGeojson = "{\n"
                + "  \"type\": \"MultiLineString\",\n"
                + "  \"coordinates\": [\n"
                + "    [\n"
                + "      [120,30],\n"
                + "      [121,31]\n"
                + "    ],\n"
                + "    [\n"
                + "      [  122,30],\n"
                + "      [123,30]\n"
                + "    ]\n"
                + "  ],\n"
                + "  \"crs\": \"EPSG:4326\"\n"
                + "}";
        MapGeometry execute = OperatorImportFromGeoJson.local()
                .execute(0, Type.Polyline, plGeojson, null);
        Polyline geometry = (Polyline) execute.getGeometry();
        System.out.println(geometry);
    }

    private static void createPolylineFromJson() {
        String plJson = "{\"paths\":[[[120,30],[121,30]],[[122,30],[121,30]]]}";
        MapGeometry execute = OperatorImportFromJson.local().execute(Type.Polyline, plJson);
        Polyline pl = (Polyline) execute.getGeometry();
        System.out.println(pl);
    }

    private static void methodCreatePolyline() {
        Polyline polyline = new Polyline();
        polyline.startPath(120, 30);
        polyline.lineTo(121, 30);

        polyline.startPath(122, 30);
        polyline.lineTo(121, 30);
        System.out.println(polyline);
    }

}
