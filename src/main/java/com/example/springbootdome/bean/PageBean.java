package com.example.springbootdome.bean;

import lombok.Data;

@Data
public class PageBean {
  private int pageSize = 1;
  private int total = 10;
  
}
