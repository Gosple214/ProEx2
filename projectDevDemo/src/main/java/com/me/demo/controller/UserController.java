package com.me.demo.controller;

import com.me.demo.common.ApiResponse;
import com.me.demo.common.DataType;
import com.me.demo.common.ParamType;
import com.me.demo.entity.User;
import com.me.demo.common.ApiResponse;
import com.me.demo.common.DataType;
import com.me.demo.common.ParamType;
import com.me.demo.entity.User;
import com.me.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * User Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-29 11:30
 */
@RestController
@RequestMapping("/user")
@Api(tags = "1.0.0-SNAPSHOT", description = "用户管理", value = "用户管理")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/findUserByName")
    @ApiOperation(value = "条件查询（DONE）", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "xxx")})
    public ApiResponse<User> getByUserName(String username) {
        log.info("多个参数用  @ApiImplicitParams");
        return ApiResponse.<User>builder().code(200).message("操作成功").data(userService.findUserByName(username)).build();
    }

    @GetMapping("/findUserById/{id}")
    @ApiOperation(value = "主键查询（DONE）", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)})
    public ApiResponse<User> get(@PathVariable Integer id) {
        log.info("单个参数用  @ApiImplicitParam");
        return ApiResponse.<User>builder().code(200).message("操作成功").data(userService.findUserById(id)).build();
    }

    @PostMapping("deleteUserById/{id}")
    @ApiOperation(value = "删除用户（DONE）", notes = "备注")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)
    public ApiResponse<Object> delete(@PathVariable Integer id) {
        log.info("单个参数用 ApiImplicitParam");
        userService.deleteUserById(id);
        return ApiResponse.<Object>builder().code(200).message("删除用户成功").data(null).build();
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户（DONE）")
    public ApiResponse<Object> post(@RequestBody User user) {
        log.info("增加用户:{}",user.getName());
        userService.addUser(user);
        return ApiResponse.<Object>builder().code(200).message("添加用户成功").data(null).build();
    }
    @PostMapping("/updateUser")
    @ApiOperation(value = "更新用户（DONE）")
    public ApiResponse<Object> updateUser(User user){
        log.info("更新用户:{}的信息",user.getName());
        userService.updateUser(user);
        return ApiResponse.<Object>builder().code(200).message("更新用户信息成功").data(null).build();
    }
}
