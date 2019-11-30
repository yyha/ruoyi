package com.ruoyi.app.domain.wallet;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 【请填写功能名称】对象 cct_money_income
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
@Data
@ToString
public class CctMoneyIncome extends BaseEntity
{


    /** 钱包记录id */
    private Integer id;

    /** 村民id */
    @Excel(name = "村民id")
    private Integer uId;

    /** 任务id */
    @Excel(name = "任务id")
    private Integer tId;

    /** 收入金额 */
    @Excel(name = "收入金额")
    private BigDecimal incomeMoney;


    /** 收入时间 */
    private Date createTime;


}
