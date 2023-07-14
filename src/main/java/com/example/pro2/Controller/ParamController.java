package com.example.pro2.Controller;

import com.example.pro2.bo.UserBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "接口传参方式")
@RestController
public class ParamController {
    @ApiOperation("无注解方式")
    @GetMapping(value = "/noannotation")
    public UserBO noAnnotation(UserBO user) {
        return user;
    }

    @ApiOperation("requestParam方式")
    @GetMapping(value = "/requestParam")
    public UserBO requestParam(@RequestParam String name, @RequestParam int age) {
        UserBO user = new UserBO();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @ApiOperation("pathVariable方式")
    @GetMapping(value = "/pathVariable/{name}/{age}")
    // http://localhost:8080/pathVariable/pathVariable/2
    public UserBO pathVariable(@PathVariable String name, @PathVariable int age) {
        UserBO user = new UserBO();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @ApiOperation("requestBody方式")
    @PostMapping(value = "/requestBody")
    public UserBO requestBody(@Valid @RequestBody UserBO userBO) {
        return userBO;
    }
}
