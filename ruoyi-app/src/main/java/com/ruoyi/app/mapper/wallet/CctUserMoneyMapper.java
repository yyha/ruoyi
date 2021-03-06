package com.ruoyi.app.mapper.wallet;


import com.ruoyi.app.domain.wallet.CctUserMoney;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
public interface CctUserMoneyMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CctUserMoney selectCctUserMoneyById(Integer id);

    public CctUserMoney selectCctUserMoneyByUserId(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cctUserMoney 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CctUserMoney> selectCctUserMoneyList(CctUserMoney cctUserMoney);

    /**
     * 新增【请填写功能名称】
     * 
     * @param cctUserMoney 【请填写功能名称】
     * @return 结果
     */
    public int insertCctUserMoney(CctUserMoney cctUserMoney);

    /**
     * 修改【请填写功能名称】
     * 
     * @param cctUserMoney 【请填写功能名称】
     * @return 结果
     */
    public int updateCctUserMoney(CctUserMoney cctUserMoney);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCctUserMoneyById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctUserMoneyByIds(String[] ids);
}
