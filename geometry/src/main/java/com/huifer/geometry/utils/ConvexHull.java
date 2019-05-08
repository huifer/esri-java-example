package com.huifer.geometry.utils;

import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Operator;
import com.esri.core.geometry.OperatorConvexHull;
import com.esri.core.geometry.OperatorDensifyByLength;
import com.esri.core.geometry.OperatorFactoryLocal;
import com.esri.core.geometry.Polygon;

/**
 * <p>Title : ConvexHull </p>
 * <p>Description : ConvexHull</p>
 *
 * @author huifer
 * @date 2019-05-08
 */
public class ConvexHull {

    public static final OperatorConvexHull bounding = (OperatorConvexHull) OperatorFactoryLocal
            .getInstance().getOperator(
                    Operator.Type.ConvexHull);
    public static final OperatorDensifyByLength densify = (OperatorDensifyByLength) OperatorFactoryLocal
            .getInstance().getOperator(Operator.Type.DensifyByLength);

    /**
     * convexHull
     *
     * @param geometry geometry
     * @return convexHull
     */
    static Geometry geometryConvexHull(Geometry geometry) {
        if (geometry instanceof MultiPoint || geometry instanceof Polygon) {

            Polygon convexHull = (Polygon) (bounding.execute(geometry, null));
            return convexHull;
        }
        return null;
    }


}
