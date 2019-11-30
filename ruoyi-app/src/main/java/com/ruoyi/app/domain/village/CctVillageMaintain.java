package com.ruoyi.app.domain.village;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 村维修对象 cct_village_maintain
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
public class CctVillageMaintain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long uId;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactMobile;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String address;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String description;

    /** 维修状态：1：处理中 2：维修中  3：维修完成  4：已取消 */
    @Excel(name = "维修状态：1：处理中 2：维修中  3：维修完成  4：已取消")
    private Integer status;

    /** 申请人姓名 */
    private String applyName;

    /** 维修人姓名 */
    private String repairName;

    /** 维修人电话 */
    private String repairPhone;

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone;
    }

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
    public void setContactMobile(String contactMobile) 
    {
        this.contactMobile = contactMobile;
    }

    public String getContactMobile() 
    {
        return contactMobile;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uId", getUId())
            .append("contactMobile", getContactMobile())
            .append("address", getAddress())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
