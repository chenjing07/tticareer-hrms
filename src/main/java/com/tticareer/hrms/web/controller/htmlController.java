package com.tticareer.hrms.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>CreateTime: 创建时间：2018年9月21日 下午5:09:23 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: htmlController.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: 页面跳转，配合80端口使用，输入ip直接进入主页</p>
 */
@RestController
public class htmlController {

    @RequestMapping("/")
    public ModelAndView getThymeleaf() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

}
