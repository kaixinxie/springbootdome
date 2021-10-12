package com.example.springbootdome.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author xkx
 * @since 2021-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CmUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    @TableField("USER_ACCOUNT")
    private String userAccount;

    /**
     * 用户密码
     */
    @TableField("USER_PASSWORD")
    private String userPassword;

    @TableField("USER_ADDRESS")
    private String userAddress;

    /**
     * 用户名称
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 联系方式
     */
    @TableField("USER_PHONE")
    private String userPhone;

    /**
     * 居住地
     */
    @TableField("USER_RESIDENCE")
    private String userResidence;

    /**
     * 用户居住地类型
     */
    @TableField("USER_RESIDENCR_TYPE")
    private String userResidencrType;

    /**
     * 备注
     */
    @TableField("USER_REMARK")
    private String userRemark;


}
