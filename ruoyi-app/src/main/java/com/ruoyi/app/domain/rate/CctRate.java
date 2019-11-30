package com.ruoyi.app.domain.rate;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 手续费 对象 cct_rate
 * 
 * @author ruoyi
 * @date 2019-11-23
 */

@Data
@ToString
public class CctRate extends BaseEntity
{


    /** 手续费id */
    private Integer rId;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal rate;


}
