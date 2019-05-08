package com.huifer.geometry.esri_geometry;

import com.esri.core.geometry.GeoJsonImportFlags;
import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.Geometry.Type;
import com.esri.core.geometry.MapGeometry;
import com.esri.core.geometry.OperatorImportFromGeoJson;
import com.esri.core.geometry.OperatorImportFromJson;
import com.esri.core.geometry.OperatorImportFromWkt;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.WktImportFlags;

/**
 * <p>Title : EsriPoint </p>
 * <p>Description : esriPoint</p>
 *
 * @author huifer
 * @date 2019-05-07
 */
public class EsriPoint {

    public static void main(String[] args) throws Exception {
        // 使用构造函数进行创建
        Point point_3d = new Point(120.0, 30.0, 2);
        Point point_2d = new Point(120.0, 30.0);
        // 使用JSON进行创建
        //language=JSON
        String point_json = "{\n"
                + "  \"x\": 120.0,\n"
                + "  \"y\": 30.0,\n"
                + "  \"spatialReference\": {\n"
                + "    \"wkid\": 4326\n"
                + "  }\n"
                + "}";

        MapGeometry geom = OperatorImportFromJson.local().execute(Type.Point, point_json);
        Point pointFromJson = (Point) geom.getGeometry();

        // 使用GeoJson进行创建
        //language=JSON
        String point_geojson = "{\n"
                + "  \"type\": HogcPoint,\n"
                + "  \"coordinates\": [120,30],\n"
                + "  \"crs\": \"EPSG:4326\"\n"
                + "}";
        MapGeometry execute = OperatorImportFromGeoJson.local()
                .execute(GeoJsonImportFlags.geoJsonImportDefaults, Type.Point, point_geojson, null);

        Point pointFromGeoJson = (Point) execute.getGeometry();

        // 使用wkt创建
        String point_wkt = "POINT(120 30)";
        Geometry execute1 = OperatorImportFromWkt.local()
                .execute(WktImportFlags.wktImportDefaults, Type.Point, point_wkt, null);

        Point pointFromWkt = (Point) execute1;


    }

}
