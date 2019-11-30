package com.ruoyi.app.domain.task;

import lombok.Data;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 任务对象 cct_task
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Data
@ToString
public class CctTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long tId;

    /** 村庄id */
    @Excel(name = "村庄id")
    private Long vId;

    /** 任务类型  0：打扫任务, 1：植树任务,2：纺织任务 */
    @Excel(name = "任务类型  0：打扫任务, 1：植树任务,2：纺织任务")
    private Integer type;

    /** 工资计算方式  1：一口价,2：时结,3：日结,4：计件 */
    @Excel(name = "工资计算方式  1：一口价,2：时结,3：日结,4：计件")
    private Integer paymentType;

    /** 任务标题 */
    @Excel(name = "任务标题")
    private String title;

    /** 任务金额 */
    @Excel(name = "任务金额")
    private BigDecimal money;

    /** 所需人数 */
    @Excel(name = "所需人数")
    private Long personNum;

    /** 发布时间 */
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pubdate;

    /** 任务到期时间 */
    @Excel(name = "任务到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishdate;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String image;

    /** 详细说明 */
    @Excel(name = "详细说明")
    private String description;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long pageView;

    /** 0未满，1已满 */
    @Excel(name = "0未满，1已满")
    private Integer isyet;

    /** 是否手工，0是,1不是 */
    @Excel(name = "是否手工，0是,1不是")
    private Integer ishandwork;

    /**加入人数*/
    private Integer joinNum;

    private String[] images;

}
