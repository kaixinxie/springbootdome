/**
 * 错误码接口
 */
package com.example.springbootdome.enums;

/**
 * 错误码接口
 *
 * @author Pactera
 * @version $Id: ErrorCode.java, v 0.1 2016年4月28日 下午3:50:57 jacques Exp $
 */
public interface ErrorCode {

  /**
   * 获取错误码
   *
   * @return
   */
  String getCode();

  /**
   * 获取错误信息
   *
   * @return
   */
  String getDescription();
}
