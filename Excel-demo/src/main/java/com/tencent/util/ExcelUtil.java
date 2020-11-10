package com.tencent.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author v_bichengli
 * @since 2020/11/9
 */
public class ExcelUtil {

    public HSSFWorkbook createExcel(List<Map<String,Object>> list){
        //创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建一个工作表
        HSSFSheet workbookSheet = workbook.createSheet("工单明细表");

        //添加表头行
        HSSFRow row = workbookSheet.createRow(0);

        //设置单元格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        //添加表头内容
        workbookSheet.setColumnWidth(0,20*256);
        HSSFCell headCell = row.createCell(0);
        headCell.setCellValue("工单号");
        headCell.setCellStyle(cellStyle);

        workbookSheet.setColumnWidth(1,60*256);
        headCell = row.createCell(1);
        headCell.setCellValue("工单内容");
        headCell.setCellStyle(cellStyle);

        workbookSheet.setColumnWidth(2,20*256);
        headCell = row.createCell(2);
        headCell.setCellValue("操作人");
        headCell.setCellStyle(cellStyle);

        workbookSheet.setColumnWidth(3,60*256);
        headCell = row.createCell(3);
        headCell.setCellValue("操作时间");
        headCell.setCellStyle(cellStyle);

        //添加数据内容
        for (int i = 0; i < list.size(); i++) {
            row = workbookSheet.createRow(i + 1);
            Map<String,Object> map = list.get(i);
            //创建单元格设置值
            HSSFCell hssfCell = row.createCell(0);
            hssfCell.setCellValue(map.get("gongdanId")+"");
            hssfCell.setCellStyle(cellStyle);

            hssfCell = row.createCell(1);
            hssfCell.setCellValue(map.get("gongdanDEC")+"");
            hssfCell.setCellStyle(cellStyle);

            hssfCell = row.createCell(2);
            hssfCell.setCellValue(map.get("operator")+"");
            hssfCell.setCellStyle(cellStyle);

            hssfCell = row.createCell(1);
            hssfCell.setCellValue(DateUtil.getJavaDate((Double) map.get("operationTime"),false,TimeZone.getDefault()));
            hssfCell.setCellStyle(cellStyle);
        }
        //返回excel文件
        return workbook;
    }
}
