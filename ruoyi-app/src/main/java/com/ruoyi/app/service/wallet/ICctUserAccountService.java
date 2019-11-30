package com.ruoyi.app.service.wallet;


import com.ruoyi.app.domain.wallet.CctUserAccount;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
public interface ICctUserAccountService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CctUserAccount selectCctUserAccountById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cctUserAccount 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CctUserAccount> selectCctUserAccountList(CctUserAccount cctUserAccount);

    /**
     * 新增【请填写功能名称】
     * 
     * @param cctUserAccount 【请填写功能名称】
     * @return 结果
     */
    public int insertCctUserAccount(CctUserAccount cctUserAccount);

    /**
     * 修改【请填写功能名称】
     * 
     * @param cctUserAccount 【请填写功能名称】
     * @return 结果
     */
    public int updateCctUserAccount(CctUserAccount cctUserAccount);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctUserAccountByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCctUserAccountById(Integer id);
}
