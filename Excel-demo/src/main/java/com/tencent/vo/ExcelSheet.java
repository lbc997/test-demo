package com.tencent.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author v_bichengli
 * @since 2020/11/10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExcelSheet extends BaseRowModel{

    @ExcelProperty(value = "姓名",index = 0)
    private String name;

    @ExcelProperty(value = "年龄",index = 1)
    private Integer age;

    @ExcelProperty(value = "操作时间",index = 2)
    @DateTimeFormat(value = "yyyy-MM-dd HH:mm:ss")
    @ColumnWidth(value = 20)
    private Date operationTime;
}
