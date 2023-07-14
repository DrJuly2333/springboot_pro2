package com.example.pro2.bo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@ApiModel(value = "用户信息")
public class UserBO {
    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "年龄")
    @Min(value = 1, message = "年龄不能小于1")
    private int age;

    @ApiModelProperty(value = "电子邮箱")
    @Email(message = "Email格式不正确")
    private String email;

    @ApiModelProperty(value = "生日")
    @Past(message = "生日必须为过去的时间")
    private LocalDate birthDay;
}
