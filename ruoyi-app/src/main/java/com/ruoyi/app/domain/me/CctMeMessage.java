package com.ruoyi.app.domain.me;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 对象 cct_me_message
 * 
 * @author ruoyi
 * @date 2019-11-20
 */
@Data
@ToString
public class CctMeMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 消息标题 */
    @Excel(name = "消息标题")
    private String title;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String content;

    /** 是否已读，Y是 N否 */
    @Excel(name = "是否已读，Y是 N否")
    private Character isread;

    /** 发送时间 */
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;

    /** 类别  1 ：个人消息 2 : 平台消息 */
    private Long source;

    //表单查询用
    private Date beginSendTime;
    private Date endSendTime;
    public CctMeMessage() {
    }

    public CctMeMessage(Long userId, String title, String content, Date sendTime) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.sendTime = sendTime;
    }
}
