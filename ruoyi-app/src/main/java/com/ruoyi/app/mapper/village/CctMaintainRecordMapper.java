package com.ruoyi.app.mapper.village;

import com.ruoyi.app.domain.village.CctMaintainRecord;
import com.ruoyi.app.domain.village.CctVillageMaintain;

import java.util.List;

/**
 * 维修记录Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
public interface CctMaintainRecordMapper 
{
    /**
     * 查询维修记录
     * 
     * @param id 维修记录ID
     * @return 维修记录
     */
    public CctMaintainRecord selectCctMaintainRecordById(Long id);

    /**
     * 查询维修记录列表
     * 
     * @param cctMaintainRecord 维修记录
     * @return 维修记录集合
     */
    public List<CctVillageMaintain> selectCctMaintainRecordList(CctMaintainRecord cctMaintainRecord);

    /**
     * 新增维修记录
     * 
     * @param cctMaintainRecord 维修记录
     * @return 结果
     */
    public int insertCctMaintainRecord(CctMaintainRecord cctMaintainRecord);

    /**
     * 修改维修记录
     * 
     * @param cctMaintainRecord 维修记录
     * @return 结果
     */
    public int updateCctMaintainRecord(CctMaintainRecord cctMaintainRecord);

    /**
     * 删除维修记录
     * 
     * @param id 维修记录ID
     * @return 结果
     */
    public int deleteCctMaintainRecordById(Long id);

    /**
     * 批量删除维修记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctMaintainRecordByIds(String[] ids);
}
