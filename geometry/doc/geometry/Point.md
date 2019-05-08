# 点 Point

## 什么是点
- 点表示了空间中的单个位置，是所有几何类型的构造元素。一个点至少包含X坐标和Y坐标。点的坐标可以是先行单位(米)，也可以是角度单位(度数、弧度)

## 表述方式
[ESRI官网的描述](https://developers.arcgis.com/documentation/core-concepts/features-and-geometries/)
```json
{
	"x": null,
	"y": null,
	"z": null,
	"m": null,
	"spatialReference": {
		"wkid": null
	}
}
```

| 属性             | 含义                       | 填写内容         |
| ---------------- | -------------------------- | ---------------- |
| x                | 东西轴测量的坐标值         | 数字，文本，null |
| y                | 南北轴测量的坐标值         | 数字，文本，null |
| z                | 测量高度或高程的坐标值     | 数字，文本，null |
| m                | 包含用于线性引用的度量     | 数字，文本，null |
| spatialReference | 通常填写wkid用来表示坐标系 | “wkid”:4326      |

### 实例

- 2D-point

  - ```json
    {
    	"x": 120.000,
    	"y": 30.000,
    	"spatialReference": {
    		"wkid": 4326
    	}
    }
    ```

- 3D-point

  - ```json
    {
    	"x": 120.000,
    	"y": 30.000,
    	"z": 20,
    	"m": 1,
    	"spatialReference": {
    		"wkid": 4326
    	}
    }
    ```

## 代码相关

```java
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
                + HogcPoint
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
```


