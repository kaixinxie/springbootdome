package com.example.springbootdome.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdome.entity.CmUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author jobob
 * @since 2021-08-25
 */
public interface ICmUserService extends IService<CmUser> {
  
   Page<CmUser> findByUser(Page<CmUser> page);
}
