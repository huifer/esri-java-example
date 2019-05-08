package com.huifer.geometry.topology;

import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.GeometryCursor;
import com.esri.core.geometry.OperatorCut;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.SpatialReference;
import java.util.ArrayList;

/**
 * <p>Title : Cut </p>
 * <p>Description : 裁剪</p>
 *
 * @author huifer
 * @date 2019-05-08
 */
public class Cut {


    /**
     * 切割线或者面
     *
     * @param cuttee 被切割的几何物体
     * @param cutter 切割标准
     * @return 切割结果
     */
    public static ArrayList<Geometry> cutPolygonOrPolyLine(Geometry cuttee, Polyline cutter,    SpatialReference spatialReference ) {
        if (cuttee instanceof Polygon || cuttee instanceof Polyline) {

            OperatorCut opCut = OperatorCut.local();
            // spatialReference 坐标系
            GeometryCursor cursor = opCut.execute(true, cuttee, cutter, spatialReference, null);

            ArrayList<Geometry> geometries = new ArrayList<>();
            Geometry geom = null;
            while ((geom = cursor.next()) != null) {
                geometries.add(geom);
            }
            return geometries;
        }
        return null;
    }



}
