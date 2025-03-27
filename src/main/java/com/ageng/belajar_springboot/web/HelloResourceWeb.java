package com.ageng.belajar_springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @ResponseBody if you want to return a response body
// @RestController is Short for @Controller and @ResponseBody
@RequestMapping("/v1/hello/web")
public class HelloResourceWeb {

    @RequestMapping(method = RequestMethod.GET)
    public String requestMethodName() {
        return "hello";
    }

}
