package com.example.pro2.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@Api(tags = "restful接口")
public class RestfulController {
    @GetMapping("/swagger")
    @ApiOperation("Swagger接口")
    public String swagger() {
        return "swagger method";
    }
}
