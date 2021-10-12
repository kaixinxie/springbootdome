package com.example.springbootdome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdome.entity.CmUser;
import com.example.springbootdome.mapper.CmUserMapper;
import com.example.springbootdome.service.ICmUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-08-25
 */
@Service
public class CmUserServiceImpl extends ServiceImpl<CmUserMapper, CmUser> implements ICmUserService {
  @Autowired
  CmUserMapper userMapper;
  
  @Override
  public Page<CmUser> findByUser(Page<CmUser> page) {
    Page<CmUser> cmUserPage = userMapper.selectPage(page, new QueryWrapper<>());
    return cmUserPage;
  }
}
