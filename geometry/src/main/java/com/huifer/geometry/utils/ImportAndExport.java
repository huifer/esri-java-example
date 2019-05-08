package com.huifer.geometry.utils;

import com.esri.core.geometry.Operator;
import com.esri.core.geometry.OperatorExportToESRIShape;
import com.esri.core.geometry.OperatorFactoryLocal;
import com.esri.core.geometry.OperatorImportFromESRIShape;

/**
 * <p>Title : ImportAndExport </p>
 * <p>Description : </p>
 *
 * @author huifer
 * @date 2019-05-08
 */
public class ImportAndExport {

    public static final OperatorExportToESRIShape exporterShape = (OperatorExportToESRIShape) OperatorFactoryLocal
            .getInstance().getOperator(
                    Operator.Type.ExportToESRIShape);
    public static final OperatorImportFromESRIShape importerShape = (OperatorImportFromESRIShape) OperatorFactoryLocal
            .getInstance().getOperator(Operator.Type.ImportFromESRIShape);





}
