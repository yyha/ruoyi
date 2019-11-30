package com.ruoyi.app.domain.task;

import lombok.Data;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.ToString;

/**
 * 用户信用分数对象 cct_user_score
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Data
@ToString
public class CctUserScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long uId;

    /** 登录名称 */
    @Excel(name = "登录名称")
    private String loginName;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 分数 */
    @Excel(name = "分数")
    private Long score;

    public CctUserScore() {
    }

    public CctUserScore(Long uId, Long score) {
        this.uId = uId;
        this.score = score;
    }

    public CctUserScore(Long id, Long uId, String loginName, String userName, String phonenumber, Long score) {
        this.id = id;
        this.uId = uId;
        this.loginName = loginName;
        this.userName = userName;
        this.phonenumber = phonenumber;
        this.score = score;
    }
}
