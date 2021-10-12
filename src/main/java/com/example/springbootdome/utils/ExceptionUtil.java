package com.example.springbootdome.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * 异常信息工具类
 *
 * @author Pactera
 */
@Slf4j
public class ExceptionUtil {
  public static final int REDO_OK_FLAG = 500;
  public static final int REDO_NG_FLAG = 600;
  
  private static final String EXCEPTION_LINE_INFO = "Exception Thread[ID : {} Name : {}] - Message : {}";
  private static final String EXCEPTION_LINE_CLASS = "Exception Class[{} Method : {} Line : {}]";
  private static final String EXCEPTION_LINE = "Exception {}]";
  private static final String PACTERA_PACKAGE_NAME = "com.pactera";
  
  private static final String CHECK_INFO_REG = ".*\\{\\}.*";
  
  /**
   * 异常信息 {} 替换
   *
   * @param exceptionInfo
   * @param params
   * @return
   */
  public static String procExceptionInfo(String exceptionInfo, String... params) {
    if (!exceptionInfo.matches(CHECK_INFO_REG)) {
      return exceptionInfo;
    }
    StringBuffer rtnSb = new StringBuffer();
    Pattern pattern = compile("(?<msgInfo>.*?\\{}[^\\{]*)");
    Matcher matcher = pattern.matcher(exceptionInfo);
    int msgCount = 0;
    while (matcher.find()) {
      String msgPara = "";
      if (msgCount <= params.length - 1) {
        msgPara = params[msgCount];
      }
      rtnSb.append(matcher.group("msgInfo").replaceAll("\\{\\}", msgPara));
      msgCount++;
    }
    return rtnSb.toString();
  }
  
  public static void logExceptionInfo(Exception ex) {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    log.error(EXCEPTION_LINE_INFO, threadId, threadName, ExceptionUtils.getMessage(ex) + " - " + ExceptionUtils.getRootCauseMessage(ex));
//    String[] exceptionList = ExceptionUtils.getRootCauseStackTrace(ex);
//    for (int i = 0; i < exceptionList.length; i++) {
//      if (i > 10) {
//        break;
//      }
//      String exceptionStr = exceptionList[i];
//      log.error(EXCEPTION_LINE, exceptionStr);
//    }
  }
  
  public static String getExceptionInfo(Throwable ex) {
    StringBuilder exceptionInfoString = new StringBuilder();
    exceptionInfoString.append(ExceptionUtils.getMessage(ex)).append(" - ").append(ExceptionUtils.getRootCauseMessage(ex));
    String[] exceptionList = ExceptionUtils.getRootCauseStackTrace(ex);
    int sourceErrorCount = 0;
    for (int i = 0; i < exceptionList.length; i++) {
      if (sourceErrorCount > 5) {
        break;
      }
      String exceptionStr = exceptionList[i];
      if (exceptionStr.contains(PACTERA_PACKAGE_NAME)) {
        sourceErrorCount++;
      }
      exceptionInfoString.append(exceptionStr);
    }
    return exceptionInfoString.toString();
  }
  
  public static String getExceptionMessage(Throwable ex) {
    return ExceptionUtils.getMessage(ex);
  }
}
