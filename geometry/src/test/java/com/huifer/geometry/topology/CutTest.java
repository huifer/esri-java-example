package com.huifer.geometry.topology;

import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.Geometry.Type;
import com.esri.core.geometry.OperatorImportFromWkt;
import com.esri.core.geometry.*;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.WktImportFlags;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class CutTest {

    private static Polygon createPgFromWkt(String pgWkt) {
        Geometry geom = OperatorImportFromWkt
                .local()
                .execute(WktImportFlags.wktImportDefaults, Geometry.Type.Polygon, pgWkt, null);

        Polygon pg = (Polygon) geom;
        return pg;
    }

    private static Polyline createPolylineFromWKT(String plWKT) {
        Geometry geom = OperatorImportFromWkt
                .local().execute(WktImportFlags.wktImportDefaults, Type.Polyline, plWKT, null);
        Polyline geometry = (Polyline) geom;
        return geometry;
    }

    @Test
    public void cutPolygonOrPolyLine() {
        // cuttee 被切割的物体 类型为(polygon , polyline)
        Polygon cuttee = createPgFromWkt("POLYGON(( 120 30 , 121 32, 110 20, 120 30 ))");
        // cutter 切割的剪刀 类型为( Polyline)
        Polyline cutter = createPolylineFromWKT("LINESTRING( 120 30 , 0 0)");
        SpatialReference spatialReference = SpatialReference.create(4326);
        ArrayList<Geometry> geometries = Cut.cutPolygonOrPolyLine(cuttee, cutter, spatialReference);
        Assert.assertTrue(geometries.size() == 2);
    }
}
