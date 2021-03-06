package com.ruoyi.app.mapper.rate;


import com.ruoyi.app.domain.rate.CctRate;

import java.util.List;

/**
 * 手续费Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-23
 */
public interface CctRateMapper 
{
    /**
     * 查询手续费
     * 
     * @param rId 手续费ID
     * @return 手续费
     */
    public CctRate selectCctRateById(Integer rId);

    /**
     * 查询手续费列表
     * 
     * @param cctRate 手续费
     * @return 手续费集合
     */
    public List<CctRate> selectCctRateList(CctRate cctRate);

    /**
     * 新增手续费
     * 
     * @param cctRate 手续费
     * @return 结果
     */
    public int insertCctRate(CctRate cctRate);

    /**
     * 修改手续费
     * 
     * @param cctRate 手续费
     * @return 结果
     */
    public int updateCctRate(CctRate cctRate);

    /**
     * 删除手续费
     * 
     * @param rId 手续费ID
     * @return 结果
     */
    public int deleteCctRateById(Integer rId);

    /**
     * 批量删除手续费
     * 
     * @param rIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctRateByIds(String[] rIds);
}
