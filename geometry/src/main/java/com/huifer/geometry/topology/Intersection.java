package com.huifer.geometry.topology;

import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.GeometryCursor;
import com.esri.core.geometry.OperatorIntersection;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.SimpleGeometryCursor;
import com.esri.core.geometry.SpatialReference;
import java.util.ArrayList;

/**
 * <p>Title : Intersection </p>
 * <p>Description : 相交操作</p>
 *
 * @author huifer
 * @date 2019-05-08
 */
public class Intersection {


    /**
     * intersection
     *
     * @param polygon polygon
     * @param polyline polyline
     * @param sr 坐标系
     * @return 相交的几何列表
     */
    public static ArrayList<Geometry> geomIntersection(Polygon polygon, Polyline polyline,
            SpatialReference sr) {
        SimpleGeometryCursor inGeoms = new SimpleGeometryCursor(polyline);
        SimpleGeometryCursor intersector = new SimpleGeometryCursor(polygon);

        GeometryCursor execute = OperatorIntersection.local()
                .execute(inGeoms, intersector, sr, null);

        Geometry geom = null;
        ArrayList<Geometry> geometries = new ArrayList<>();
        while ((geom = execute.next()) != null) {
            // 转换成WKT
//            String execute1 = OperatorExportToWkt.local().execute(0, geom, null);
//            System.out.println(execute1);
            geometries.add(geom);
        }
        return geometries;
    }


}
