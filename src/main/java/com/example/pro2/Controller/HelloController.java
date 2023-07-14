package com.example.pro2.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(tags = "Hello控制器")
public class HelloController {
    @ApiOperation(value = "hello")
    @GetMapping("/hello")
    public String Hello() {
        log.info("hello");
        return "Hello World!";
    }
}
