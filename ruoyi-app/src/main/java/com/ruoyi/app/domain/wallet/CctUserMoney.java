package com.ruoyi.app.domain.wallet;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 【请填写功能名称】对象 cct_user_money
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
@Data
@ToString
public class CctUserMoney extends BaseEntity
{

    /** $column.columnComment */
    private Integer id;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer uId;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal money;


}
