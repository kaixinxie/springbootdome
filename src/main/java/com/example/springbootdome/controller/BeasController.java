package com.example.springbootdome.controller;

import com.example.springbootdome.bean.ResultBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.springbootdome.controller.BeasController.API;

@RestController
@RequestMapping(API)
public abstract class BeasController {
  
  public final static String API="/TeachingAids";
  
  @GetMapping("/menu")
  public ResultBean getMenu(){
    return ResultBean.ok();
  }
  
}
