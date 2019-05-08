package com.huifer.geometry.topology;

import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.GeometryCursor;
import com.esri.core.geometry.MultiPath;
import com.esri.core.geometry.Operator;
import com.esri.core.geometry.OperatorFactoryLocal;
import com.esri.core.geometry.OperatorUnion;
import com.esri.core.geometry.SimpleGeometryCursor;
import com.esri.core.geometry.SpatialReference;

/**
 * <p>Title : Union </p>
 * <p>Description : union</p>
 *
 * @author huifer
 * @date 2019-05-08
 */
public class Union {


    /**
     * union
     *
     * @param geomArray geom 数组
     * @return MultiPath
     */
    public static MultiPath union(Geometry[] geomArray) {
        SimpleGeometryCursor inputGeometries = new SimpleGeometryCursor(
                geomArray);
        OperatorUnion union = (OperatorUnion) OperatorFactoryLocal
                .getInstance().getOperator(Operator.Type.Union);

        SpatialReference sr = SpatialReference.create(4326);
        GeometryCursor outputCursor = union.execute(inputGeometries, sr, null);
        Geometry result = outputCursor.next();
        MultiPath path = (MultiPath) result;
        return path;
    }

}
