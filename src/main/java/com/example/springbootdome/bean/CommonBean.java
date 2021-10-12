package com.example.springbootdome.bean;

import lombok.Data;

import java.util.List;

@Data
public class CommonBean<T> extends PageBean {
  private T params;
  private List<T> paramsList;
}
