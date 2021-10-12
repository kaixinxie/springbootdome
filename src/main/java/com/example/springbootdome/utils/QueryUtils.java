package com.example.springbootdome.utils;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.springbootdome.enums.BizResultCodeEnum;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Optional;

public class QueryUtils {
  
  /**
   * 查询Key 转换 DB Key
   *
   * @param clz      Entity
   * @param queryKey 查询Key
   * @return DB Key
   */
  @SneakyThrows
  public static String getTableFieldName(Class clz, String queryKey) {
    Field field = ReflectUtil.getField(clz, queryKey);
    String fieldName = (String) Optional.ofNullable(AnnotationUtil.getAnnotationValue(field, TableField.class))
      .orElse(AnnotationUtil.getAnnotationValue(field, TableId.class));
    
    return Optional.ofNullable(fieldName).orElseThrow(() -> new Throwable(StrUtil.format(BizResultCodeEnum.SYS_ERR_INVALID_QUERY_KEY.getDescription(), queryKey)));
  }
}
