package com.ruoyi.app.domain.wallet;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * 【请填写功能名称】对象 cct_user_account
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
@Data
@ToString
public class CctUserAccount extends BaseEntity
{

    /** $column.columnComment */
    private Integer id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer uId;

    /** 账号类型:(0:银行卡，1:微信，2:支付宝) */
    @Excel(name = "账号类型:(0:银行卡，1:微信，2:支付宝)")
    private Integer accountType;

    /** 账号 */
    @Excel(name = "账号")
    private String account;


}
