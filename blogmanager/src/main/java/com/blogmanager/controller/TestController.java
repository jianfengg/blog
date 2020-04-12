package com.blogmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

    @GetMapping("/hello")
    public ModelAndView hello() {
        return new ModelAndView("/index");
    }

    @GetMapping("/test")
    public ModelAndView test() {
        return new ModelAndView("/test");
    }

    /**
     * 随便进个页面
     * @return
     */
    @GetMapping("/main")
    public ModelAndView main() {
        return new ModelAndView("/main");
    }
}
