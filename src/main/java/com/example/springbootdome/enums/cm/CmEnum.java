package com.example.springbootdome.enums.cm;

import lombok.Data;


public enum CmEnum {
  
  ACCOUNT_AND_PASSWORD_ERROR("账户或密码错误！");
  
  private String value;
  

  private CmEnum(String value) {
    this.value = value;
  }
  
  public String getValue() {
    return value;
  }
}
