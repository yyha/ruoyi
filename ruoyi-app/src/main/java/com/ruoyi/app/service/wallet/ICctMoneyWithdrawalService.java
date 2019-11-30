package com.ruoyi.app.service.wallet;


import com.ruoyi.app.domain.wallet.CctMoneyWithdrawal;
import com.ruoyi.common.core.domain.AjaxResult;

import java.util.List;
import java.util.Map;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
public interface ICctMoneyWithdrawalService 
{

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CctMoneyWithdrawal selectCctMoneyWithdrawalById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cctMoneyWithdrawal 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CctMoneyWithdrawal> selectCctMoneyWithdrawalList(CctMoneyWithdrawal cctMoneyWithdrawal);

    /**
     * 新增提现
     * 
     * @param cctMoneyWithdrawal 【请填写功能名称】
     * @return 结果
     */
    public AjaxResult insertCctMoneyWithdrawal(CctMoneyWithdrawal cctMoneyWithdrawal);

    /**
     * 修改【请填写功能名称】
     * 
     * @param cctMoneyWithdrawal 【请填写功能名称】
     * @return 结果
     */
    public int updateCctMoneyWithdrawal(CctMoneyWithdrawal cctMoneyWithdrawal);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctMoneyWithdrawalByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCctMoneyWithdrawalById(Integer id);

    /**
     * 展示余额与手续费率
     * @param id
     * @return
     */
    public Map selectMoneyAndRate(Integer id);


    /**
     * 提现审核
     * @param cctMoneyWithdrawal 对象
     * @return
     */
    public int WithdrawalAudit(CctMoneyWithdrawal cctMoneyWithdrawal);
}
