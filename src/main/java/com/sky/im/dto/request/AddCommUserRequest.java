package com.sky.im.dto.request;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class AddCommUserRequest extends CheckRequest {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "用户密码不能为空")
    private String password;

    @NotBlank(message = "手机号码不能为空")
    @Length(min = 11, max = 11, message = "手机号码长度必须是11")
    @Pattern(regexp = "^((13[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$", message = "手机号码格式不正确")
    private String mobile;
    @NotBlank(message = "真实姓名不能为空")
    private String realName;


    private Integer gender;

    private String email;

    private String remark;
}
