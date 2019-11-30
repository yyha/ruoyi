package com.ruoyi.app.domain.village;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * 村庄对象 cct_village
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Data
@ToString
public class CctVillage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long vId;

    /** 村庄名称 */
    @Excel(name = "村庄名称")
    private String vName;

    /** 村庄图片 */
    private String vImage;

    /** 是否是推荐村庄 */
    private Boolean recommend;




}
