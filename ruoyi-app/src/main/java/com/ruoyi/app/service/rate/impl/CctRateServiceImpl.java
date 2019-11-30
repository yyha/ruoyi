package com.ruoyi.app.service.rate.impl;

import java.util.List;

import com.ruoyi.app.domain.rate.CctRate;
import com.ruoyi.app.mapper.rate.CctRateMapper;
import com.ruoyi.app.service.rate.ICctRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 手续费Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-23
 */
@Service
public class CctRateServiceImpl implements ICctRateService
{
    @Autowired
    private CctRateMapper cctRateMapper;

    /**
     * 查询手续费
     * 
     * @param rId 手续费ID
     * @return 手续费
     */
    @Override
    public CctRate selectCctRateById(Integer rId)
    {
        return cctRateMapper.selectCctRateById(rId);
    }

    /**
     * 查询手续费列表
     * 
     * @param cctRate 手续费
     * @return 手续费
     */
    @Override
    public List<CctRate> selectCctRateList(CctRate cctRate)
    {
        return cctRateMapper.selectCctRateList(cctRate);
    }

    /**
     * 新增手续费
     * 
     * @param cctRate 手续费
     * @return 结果
     */
    @Override
    public int insertCctRate(CctRate cctRate)
    {
        return cctRateMapper.insertCctRate(cctRate);
    }

    /**
     * 修改手续费
     * 
     * @param cctRate 手续费
     * @return 结果
     */
    @Override
    public int updateCctRate(CctRate cctRate)
    {
        return cctRateMapper.updateCctRate(cctRate);
    }

    /**
     * 删除手续费对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctRateByIds(String ids)
    {
        return cctRateMapper.deleteCctRateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除手续费信息
     * 
     * @param rId 手续费ID
     * @return 结果
     */
    @Override
    public int deleteCctRateById(Integer rId)
    {
        return cctRateMapper.deleteCctRateById(rId);
    }
}
