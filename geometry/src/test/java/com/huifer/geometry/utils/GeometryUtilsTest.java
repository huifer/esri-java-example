package com.huifer.geometry.utils;

import static org.junit.Assert.assertEquals;

import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.MultiPoint;
import org.junit.Test;

public class GeometryUtilsTest {


    @Test
    public void getGeometryType() {
        MultiPoint mp = new MultiPoint();
        String geometryType = GeometryUtils.getGeometryType(mp);
        assertEquals("esriGeometryMultipoint", geometryType);
    }

    @Test
    public void getGeometryFromJSon() {
        String json = "{\"type\":\"Point\",\"coordinates\":[0,0]}";
        Geometry geometryFromJSon = GeometryUtils.getGeometryFromJSon(json);
        System.out.println(geometryFromJSon);
    }

}
