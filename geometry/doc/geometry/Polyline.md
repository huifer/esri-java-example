# Polyline
## 什么是polyline

- polyline 是多条线段的集合，单条线段由多个点按照连接顺序排列表述	

## 表述方式
[ESRI官网的描述](https://developers.arcgis.com/web-map-specification/objects/polyline_geometry/)

```json
{
    "hasZ":true,
    "hasM":true,
    "paths":[
        [
            [x11,y11],
            [x12,y12],
        ],
        [
            [x21,y21],
            [x22,y22]
        ]
        ...
    ],
	"spatialReference": {
		"wkid": null
	}
}
```

| 属性             | 含义                       | 填写内容                                         |
| ---------------- | -------------------------- | ------------------------------------------------ |
| hasZ             | 是否包含Z坐标              | true\false                                       |
| hasM             | 是否包含M坐标              | true\false                                       |
| paths            | 线段集合                   | [[第一根线段的坐标集合]，[第二根线段的坐标集合]] |
| spatialReference | 通常填写wkid用来表示坐标系 | “wkid”:4326                                      |

- 2D-Polyline

  - ```json
    {
        "hasZ": false,
        "hasM": false,
    	"paths": [
    		[
    			[120, 30],
    			[121, 30]
    		],
    		[
    			[122,30],
    			[123,31]
    		]
    	],
    	"spatialReference": {
    		"wkid": 4326
    	}
    }
    ```

- 3D-Polyline

  - ```json
    {
        "hasZ": true,
        "hasM": true,
    	"paths": [
    		[
    			[120, 30,1],
    			[121, 30,1]
    		],
    		[
    			[122,30,1],
    			[123,31,1]
    		]
    	],
    	"spatialReference": {
    		"wkid": 4326
    	}
    }
    ```

    

## 代码相关

```java
package com.huifer.geometry;

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

```
