package com.example.springbootdome.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * 业务错误码
 *
 * @author Pactera
 */
public enum BizResultCodeEnum implements ErrorCode {
  
  /**
   * 系统消息
   */
  OK("200", "处理正常"),
  UNSPECIFIED("X000", "网络异常"),
  UNKNOW_ERROR("X001", "系统或网络异常"),
  SYS_ERR_INVALID_QUERY_KEY("SE007", "查询字段不存在 - {} "),
  ;
  
  /**
   * 错误码
   */
  private final String code;
  
  /**
   * 描述
   */
  private final String description;
  
  /**
   * @param code        错误码
   * @param description 描述
   */
  private BizResultCodeEnum(final String code, final String description) {
    this.code = code;
    this.description = description;
  }
  
  /**
   * 根据编码查询枚举。
   *
   * @param code 编码。
   * @return 枚举。
   */
  public static BizResultCodeEnum getByCode(String code) {
    for (BizResultCodeEnum value : BizResultCodeEnum.values()) {
      if (StringUtils.equals(code, value.getCode())) {
        return value;
      }
    }
    return UNSPECIFIED;
  }
  
  /**
   * 枚举是否包含此code
   *
   * @param code 枚举code
   * @return 结果
   */
  public static Boolean contains(String code) {
    for (BizResultCodeEnum value : BizResultCodeEnum.values()) {
      if (StringUtils.equals(code, value.getCode())) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public String getCode() {
    return code;
  }
  
  @Override
  public String getDescription() {
    return description;
  }
}
