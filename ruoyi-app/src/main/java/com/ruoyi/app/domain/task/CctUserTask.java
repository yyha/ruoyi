package com.ruoyi.app.domain.task;

import lombok.Data;
import lombok.ToString;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 领取任务对象 cct_user_task
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Data
@ToString
public class CctUserTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @NotNull(message = "参数id不能为空")
    private Long id;

    /** 用户id */
    private Long userId;

    /** 用户名称 */
    private String userName;

    /** 任务id */
    @Excel(name = "任务id")
    private Long taskId;

    /** 任务状态：0待领取物料，1工作中，2已交付，3已验收，4已完成，5已延期，6已取消 */
    @Excel(name = "任务状态：0待领取物料，1工作中，2已交付，3已验收，4已完成，5已延期，6已取消")
    private Integer status;

    /** 是否延期：0否，1是 */
    @Excel(name = "是否延期：0否，1是")
    private Integer isdelay;

    /** 延期原因 */
    @Excel(name = "延期原因")
    private String delayReason;

    /** 延期至 */
    @Excel(name = "延期至", width = 30, dateFormat = "yyyy-MM-dd")
    private Date delayto;

    /** 任务完成时间 */
    @Excel(name = "任务完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishTime;

    /** 取消原因 */
    @Excel(name = "取消原因")
    private String cancelReason;

    /**发布时间*/
    private String publishTime;

    /**任务标题*/
    private String title;

    /**任务金额*/
    private BigDecimal money;

    /**需要总人数*/
    private Integer personNum;

    /**加入人数*/
    private Integer joinNum;

    /**领取时间*/
    private Date createTime;

    /**到期时间*/
    private Date finishdate;


    /**延期、取消审核*/
    private Boolean applyAudit;


    /**申请类型*/
    private Integer applyType;

    /**任务图片*/
    private String image;

    /**任务领取地址*/
    private String address;

    /**支付方式*/
    private Integer paymentType;

    /**任务类型*/
    private Integer type;

}
