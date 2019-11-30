package com.ruoyi.app.domain.me;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * 【用户与公告 中间表对象 cct_user_notice
 * 
 * @author ruoyi
 * @date 2019-11-28
 */
@Data
@ToString
public class CctUserNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uId;

    /** 公告id */
    @Excel(name = "公告id")
    private Long noticeId;

    /** 是否已读，Y是 N否 */
    @Excel(name = "是否已读，Y是 N否")
    private Character isread;


}
