package com.ruoyi.app.mapper.wallet;


import com.ruoyi.app.domain.wallet.CctMoneyWithdrawal;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
public interface CctMoneyWithdrawalMapper 
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
     * 新增【请填写功能名称】
     * 
     * @param cctMoneyWithdrawal 【请填写功能名称】
     * @return 结果
     */
    public int insertCctMoneyWithdrawal(CctMoneyWithdrawal cctMoneyWithdrawal);

    /**
     * 修改【请填写功能名称】
     * 
     * @param cctMoneyWithdrawal 【请填写功能名称】
     * @return 结果
     */
    public int updateCctMoneyWithdrawal(CctMoneyWithdrawal cctMoneyWithdrawal);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCctMoneyWithdrawalById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctMoneyWithdrawalByIds(String[] ids);
}
