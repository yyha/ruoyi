package com.ruoyi.app.service.wallet.impl;


import com.ruoyi.app.domain.wallet.CctUserAccount;
import com.ruoyi.app.mapper.wallet.CctUserAccountMapper;
import com.ruoyi.app.service.wallet.ICctUserAccountService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
@Service
public class CctUserAccountServiceImpl implements ICctUserAccountService 
{
    @Autowired
    private CctUserAccountMapper cctUserAccountMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public CctUserAccount selectCctUserAccountById(Integer id)
    {
        return cctUserAccountMapper.selectCctUserAccountById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cctUserAccount 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CctUserAccount> selectCctUserAccountList(CctUserAccount cctUserAccount)
    {
        return cctUserAccountMapper.selectCctUserAccountList(cctUserAccount);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param cctUserAccount 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCctUserAccount(CctUserAccount cctUserAccount)
    {
        cctUserAccount.setCreateTime(DateUtils.getNowDate());
        return cctUserAccountMapper.insertCctUserAccount(cctUserAccount);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param cctUserAccount 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCctUserAccount(CctUserAccount cctUserAccount)
    {
        cctUserAccount.setUpdateTime(DateUtils.getNowDate());
        return cctUserAccountMapper.updateCctUserAccount(cctUserAccount);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctUserAccountByIds(String ids)
    {
        return cctUserAccountMapper.deleteCctUserAccountByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCctUserAccountById(Integer id)
    {
        return cctUserAccountMapper.deleteCctUserAccountById(id);
    }
}
