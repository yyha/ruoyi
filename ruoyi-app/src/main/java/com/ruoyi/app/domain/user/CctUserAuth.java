package com.ruoyi.app.domain.user;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户实名认证对象 cct_user_auth
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
public class CctUserAuth extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户表id */
    @Excel(name = "用户表id")
    private Long uId;

    /** 村庄id */
    @Excel(name = "村庄id")
    private Long vId;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String realName;

    /** 身份证编号 */
    @Excel(name = "身份证编号")
    private Long cardId;

    /** 身份证正面 */
    @Excel(name = "身份证正面")
    private String cardFront;

    /** 反面 */
    @Excel(name = "反面")
    private String cardRear;

    /** 手持 */
    @Excel(name = "手持")
    private String cardHand;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUId(Long uId) 
    {
        this.uId = uId;
    }

    public Long getUId() 
    {
        return uId;
    }
    public void setVId(Long vId) 
    {
        this.vId = vId;
    }

    public Long getVId() 
    {
        return vId;
    }
    public void setRealName(String realName) 
    {
        this.realName = realName;
    }

    public String getRealName() 
    {
        return realName;
    }
    public void setCardId(Long cardId) 
    {
        this.cardId = cardId;
    }

    public Long getCardId() 
    {
        return cardId;
    }
    public void setCardFront(String cardFront) 
    {
        this.cardFront = cardFront;
    }

    public String getCardFront() 
    {
        return cardFront;
    }
    public void setCardRear(String cardRear) 
    {
        this.cardRear = cardRear;
    }

    public String getCardRear() 
    {
        return cardRear;
    }
    public void setCardHand(String cardHand) 
    {
        this.cardHand = cardHand;
    }

    public String getCardHand() 
    {
        return cardHand;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uId", getUId())
            .append("vId", getVId())
            .append("realName", getRealName())
            .append("cardId", getCardId())
            .append("cardFront", getCardFront())
            .append("cardRear", getCardRear())
            .append("cardHand", getCardHand())
            .append("createTime", getCreateTime())
            .toString();
    }
}
