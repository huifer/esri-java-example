package com.huifer.geometry.esri_geometry;

import com.esri.core.geometry.GeoJsonImportFlags;
import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.Geometry.Type;
import com.esri.core.geometry.MapGeometry;
import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.OperatorImportFromGeoJson;
import com.esri.core.geometry.OperatorImportFromJson;
import com.esri.core.geometry.OperatorImportFromWkt;
import com.esri.core.geometry.WktImportFlags;

/**
 * <p>Title : EsriMulitPoint </p>
 * <p>Description : 多点</p>
 *
 * @author huifer
 * @date 2019-05-07
 */
public class EsriMulitPoint {

    public static void main(String[] args) {
        methodCreate();
        createMpFromJson();
        createMpFromGeoJson();
        createMpFromWkt();

    }

    private static void createMpFromWkt() {
        String mpWkt = "MULTIPOINT((120 30),(121 31))";
        Geometry execute = OperatorImportFromWkt.local()
                .execute(WktImportFlags.wktImportDefaults, Type.MultiPoint, mpWkt, null);
        MultiPoint mp = (MultiPoint) execute;
        System.out.println(mp);
    }

    private static void createMpFromGeoJson() {
        String mpGeoJson = "{\n"
                + "  \"type\": \"MultiPoint\",\n"
                + "  \"coordinates\": [\n"
                + "    [120,30,1],\n"
                + "    [121,31,1]\n"
                + "  ],\n"
                + "  \"crs\": \"ESPG:4326\"\n"
                + "}";

        MapGeometry execute = OperatorImportFromGeoJson.local()
                .execute(GeoJsonImportFlags.geoJsonImportDefaults, Type.MultiPoint,
                        mpGeoJson, null);
        MultiPoint mp = (MultiPoint) execute.getGeometry();
        System.out.println(mp);
    }

    private static void createMpFromJson() {
        //language=JSON
        String mpJson = "{\n"
                + "  \"points\": [\n"
                + "    [120,30,1],\n"
                + "    [121,31,1]\n"
                + "  ],\n"
                + "  \"spatialReference\": {\n"
                + "    \"wkid\": 4326\n"
                + "  }\n"
                + "}";
        MapGeometry execute = OperatorImportFromJson.local().execute(Type.MultiPoint, mpJson);
        MultiPoint mp = (MultiPoint) execute.getGeometry();
        System.out.println(mp);
    }


    private static void methodCreate() {
        MultiPoint mp = new MultiPoint();
        mp.add(120, 30);
        mp.add(120, 30);
        System.out.println(mp);
    }

}
