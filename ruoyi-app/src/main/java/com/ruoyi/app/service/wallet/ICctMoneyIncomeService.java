package com.ruoyi.app.service.wallet;


import com.ruoyi.app.domain.wallet.CctMoneyIncome;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2019-11-25
 */
public interface ICctMoneyIncomeService {
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
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctMoneyIncomeByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCctMoneyIncomeById(Integer id);

    /**
     * 添加收入记录  于  修改钱包金额
     * @param id 村民任务 id
     * @return
     */
    public int addIncomeAndModifyThePurse(Integer id);
}
