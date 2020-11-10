package com.tencent;

import com.tencent.util.EasyExcelUtil;
import com.tencent.vo.ExcelSheet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class ExcelDemoApplicationTests {

    @Test
    public void exportExcel(){

        //导出路径
        String filePath = "F:\\demo\\test\\测试3.xlsx";

        //Excel模板->即数据库查出的数据
        ArrayList<ExcelSheet> data = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            ExcelSheet sheet = new ExcelSheet();
            sheet.setName("v_taoyi");
            sheet.setAge(20);
            sheet.setOperationTime(new Date());
            data.add(sheet);
        }
        EasyExcelUtil.writeWithTemplate(filePath,data);
        System.err.println("耗时: "+(System.currentTimeMillis()-start));
    }
    //导入读取文件
    @Test
    public void readExcel(){

        //读取目标文件
        String filePath = "F:\\demo\\test\\测试2.xlsx";
        List<Object> objects = EasyExcelUtil.readMoreThan1000Row(filePath);
        objects.forEach(System.out::println);
    }
}
