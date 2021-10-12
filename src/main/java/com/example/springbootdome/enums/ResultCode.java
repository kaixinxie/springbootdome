package com.example.springbootdome.enums;

import cn.hutool.core.util.StrUtil;

public enum ResultCode {
  
  OK(true,"200","操作成功"),
  NG(false, "ERROR", "操作失败"),;
  
  public Boolean getSuccess() {
    return success;
  }
  
  public String getCode() {
    return code;
  }
  
  public String getMsg() {
    return msg;
  }
  
  private Boolean success;
  private String code;
  private String msg;
  
  /**
   * @param code
   * @param msg
   */
  ResultCode(boolean success, String code, String msg) {
    this.success = success;
    this.code = code;
    this.msg = msg;
  }
  
  /**
   * 根据编码查询枚举。
   *
   * @param code 编码。
   * @return 枚举。
   */
  public static ResultCode getByCode(String code) {
    for (ResultCode value : ResultCode.values()) {
      if (StrUtil.equals(code, value.getMsg())) {
        return value;
      }
    }
    return null;
  }
}
