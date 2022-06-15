package com.example.springbootdome.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.db.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootdome.bean.CommonBean;
import com.example.springbootdome.bean.ResultBean;
import com.example.springbootdome.entity.CmUser;
import com.example.springbootdome.enums.cm.CmEnum;
import com.example.springbootdome.service.ICmUserService;
import com.example.springbootdome.service.impl.CmUserServiceImpl;
import com.example.springbootdome.utils.QueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.springbootdome.controller.CommonController.URL;


@RestController
@RequestMapping(URL)
public class CommonController {
 
 public final static String URL="/common/aatest";

 @Autowired
 ICmUserService userService;

 
 @GetMapping("apiState")
 public ResultBean apiState(){
  return ResultBean.ok();
 }
 
 @PostMapping("login")
 public ResultBean login(@RequestBody CommonBean<CmUser> commonBean){
  CmUser params = commonBean.getParams();
  QueryWrapper<CmUser> queryWrapper =new QueryWrapper<>();
  queryWrapper.eq(QueryUtils.getTableFieldName(CmUser.class,"userAccount"),params.getUserAccount());
  queryWrapper.eq(QueryUtils.getTableFieldName(CmUser.class,"userPassword"),params.getUserPassword());
  CmUser one = userService.getOne(queryWrapper);
  if(ObjectUtil.isNotEmpty(one)){
   return ResultBean.ok().data(one);
  }
  return ResultBean.failure().message(CmEnum.ACCOUNT_AND_PASSWORD_ERROR.getValue());
 }
 
}
