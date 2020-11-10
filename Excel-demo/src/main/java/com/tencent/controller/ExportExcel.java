package com.tencent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author v_bichengli
 * @since 2020/11/9
 */
@RestController
public class ExportExcel {

    @GetMapping("/export")
    public String export(HttpServletResponse response){
        if (response.getHeaderNames().equals("哈哈")){
            return "呵呵";
        }

        return "我又修改了东西";

    }
}
