package com.example.springbootdome.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdome.bean.CommonBean;
import com.example.springbootdome.bean.ResultBean;
import com.example.springbootdome.entity.CmUser;
import com.example.springbootdome.service.ICmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-08-25
 */
@RestController
@RequestMapping("/cmuser")
public class CmUserController {
  
  @Autowired
  ICmUserService cmUserService;

  @PostMapping("/test")
  public ResultBean getUser(@RequestBody CommonBean commonBean){
    Page<CmUser> page=new Page<>(commonBean.getPageSize(),commonBean.getTotal());
    Page<CmUser> byUser = cmUserService.findByUser(page);
    return ResultBean.ok().data(byUser);
  
  }
  
}
