package com.example.pro2.Controller;

import com.example.pro2.entity.UserEntity;
import com.example.pro2.repository.UserRepository;
import com.example.pro2.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "用户服务")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/{id}")
    public UserEntity get(@PathVariable int id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping
    public UserEntity add(@RequestBody UserEntity user) {
        return userService.add(user);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping
    public void update(@RequestBody UserEntity user) {
        userService.add(user);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

}
