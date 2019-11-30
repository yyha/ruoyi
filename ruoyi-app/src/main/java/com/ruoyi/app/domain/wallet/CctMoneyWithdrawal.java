package com.ruoyi.app.domain.wallet;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 【请填写功能名称】对象 cct_money_withdrawal
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
@Data
@ToString
public class CctMoneyWithdrawal extends BaseEntity
{

    /** 取款记录表 */
    private Integer id;

    /** 村民id */
    @Excel(name = "村民id")
    private Integer uId;

    /** 村民名字 */
    @Excel(name = "村民名字")
    private String name;

    /** 任务id */
    @Excel(name = "任务id")
    private Integer tId;

    /** 提现金额 */
    @Excel(name = "提现金额")
    private BigDecimal money;

    /** 到账金额 */
    @Excel(name = "到账金额")
    private BigDecimal realityMoney;

    /** 提现状态  0 : 提现中  1 : 提现成功 2: 提现拒绝 */
    @Excel(name = "提现状态  0 : 提现中  1 : 提现成功 2: 提现拒绝")
    private Integer status;

    /** 手续费率 */
    @Excel(name = "手续费率")
    private BigDecimal rate;

    /** 提现方式  */
    @Excel(name = "提现方式 ")
    private Integer manner;

    /** 提现拒绝原因 */
    @Excel(name = "提现拒绝原因")
    private String rejectCause;

    /** 提现时间 */
    @Excel(name = "提现时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date withdrawTime;

    /** 提现账号 */
    @Excel(name = "提现账号")
    private String mannerAccount;


}
