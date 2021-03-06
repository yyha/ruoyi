package com.ruoyi.app.mapper.wallet;


import com.ruoyi.app.domain.wallet.CctMoneyIncome;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
public interface CctMoneyIncomeMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CctMoneyIncome selectCctMoneyIncomeById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cctMoneyIncome 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CctMoneyIncome> selectCctMoneyIncomeList(CctMoneyIncome cctMoneyIncome);

    /**
     * 新增【请填写功能名称】
     * 
     * @param cctMoneyIncome 【请填写功能名称】
     * @return 结果
     */
    public int insertCctMoneyIncome(CctMoneyIncome cctMoneyIncome);

    /**
     * 修改【请填写功能名称】
     * 
     * @param cctMoneyIncome 【请填写功能名称】
     * @return 结果
     */
    public int updateCctMoneyIncome(CctMoneyIncome cctMoneyIncome);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCctMoneyIncomeById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctMoneyIncomeByIds(String[] ids);
}
