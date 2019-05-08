package com.huifer.geometry.esri_geometry;

import com.esri.core.geometry.GeoJsonImportFlags;
import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.MapGeometry;
import com.esri.core.geometry.OperatorImportFromGeoJson;
import com.esri.core.geometry.OperatorImportFromJson;
import com.esri.core.geometry.OperatorImportFromWkt;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.WktImportFlags;

/**
 * <p>Title : EsriPolygon </p>
 * <p>Description : polygon</p>
 *
 * @author huifer
 * @date 2019-05-07
 */
public class EsriPolygon {

    public static void main(String[] args) {
        createPolygonFromJson();
        createPolygonFromGeoJson();
        createPolygonFromWkt();
    }

    private static void createPolygonFromWkt() {
        String wktString = "MULTIPOLYGON (((120 30 ,121 32 ,123 33,120 30)))";

        Geometry geom = OperatorImportFromWkt
                .local()
                .execute(WktImportFlags.wktImportDefaults, Geometry.Type.Polygon, wktString, null);

        Polygon pg = (Polygon) geom;
        System.out.println(pg);
    }

    private static void createPolygonFromGeoJson() {
        //language=JSON
        String pgGeojson = "{\n"
                + "\t\"type\": \"MultiPolygon\",\n"
                + "\t\"coordinates\": [\n"
                + "\t\t[\n"
                + "\t\t\t[\n"
                + "\t\t\t\t[120, 30],\n"
                + "\t\t\t\t[121, 33],\n"
                + "\t\t\t\t[122, 35],\n"
                + "\t\t\t\t[120, 30]\n"
                + "\n"
                + "\t\t\t],\n"
                + "\t\t\t[\n"
                + "\t\t\t\t[120, 30],\n"
                + "\t\t\t\t[122, 33],\n"
                + "\t\t\t\t[122, 35],\n"
                + "\t\t\t\t[120, 30]\n"
                + "\t\t\t]\n"
                + "\t\t]\n"
                + "\n"
                + "\t],\n"
                + "\t\"crs\": \"EPSG:4326\"\n"
                + "}";
        MapGeometry geom = OperatorImportFromGeoJson
                .local()
                .execute(GeoJsonImportFlags.geoJsonImportDefaults, Geometry.Type.Polygon, pgGeojson,
                        null);

        Polygon pg = (Polygon) geom.getGeometry();
        System.out.println(pg);
    }

    private static void createPolygonFromJson() {
        //language=JSON
        String pgJson = "{\n"
                + "  \"rings\": [\n"
                + "    [\n"
                + "      [120,30],\n"
                + "      [122,33],\n"
                + "      [124,31],\n"
                + "      [120,30]\n"
                + "    ]\n"
                + "  ],\n"
                + "  \"spatialReference\": {\n"
                + "    \"wkid\": 4326\n"
                + "  }\n"
                + "}";
        MapGeometry geom = OperatorImportFromJson
                .local().execute(Geometry.Type.Polygon, pgJson);

        Polygon pg = (Polygon) geom.getGeometry();
        System.out.println(pg);
    }

}
