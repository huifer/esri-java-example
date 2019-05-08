# 多点 MultiPoint
## 什么是多点
- 一个多点是点的有序集合
## 表述方式
[ESRI官网的描述](https://developers.arcgis.com/web-map-specification/objects/multipoint_geometry/)
```json
{
	"hasZ": true,
	"hasM": true,
	"points": [
		[x1, y1, z1, m1],
		[x2, y2, z2, m2],
	],
	"spatialReference": {
		"wkid": null
	}
}
```

| 属性             | 含义                       | 填写内容                 |
| ---------------- | -------------------------- | ------------------------ |
| hasZ             | 是否包含Z坐标              | true\false               |
| hasM             | 是否包含M坐标              | true\false               |
| points           | 二维点或者三维点的集合     | 数组形式表达点[x1,y1,z1] |
| spatialReference | 通常填写wkid用来表示坐标系 | “wkid”:4326              |

### 实例

- 2D-MultiPoint

  -  ```json
    {
    	"hasZ": false,
    	"hasM": false,
    	"points": [
    		[
    			120,
    			30
    		],
    		[
    			121,
    			31
    		]
    	],
    	"spatialReference": {
    		"wkid": 4326
    	}
    }
    ```
  
- 3D-MulitPoint

  - ```json
    {
    	"hasZ": true,
    	"hasM": true,
    	"points": [
    		[
    			120,
    			30,
    		  1
    		],
    		[
    			121,
    			31,
    		  1
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

```

