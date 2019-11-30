package com.ruoyi.app.service.village.impl;

import java.util.List;

import com.ruoyi.app.domain.village.CctVillageMaintain;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.app.domain.village.CctMaintainRecord;
import com.ruoyi.app.mapper.village.CctMaintainRecordMapper;
import com.ruoyi.app.service.village.ICctMaintainRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 维修记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Service
public class CctMaintainRecordServiceImpl implements ICctMaintainRecordService
{
    @Autowired
    private CctMaintainRecordMapper cctMaintainRecordMapper;

    @Autowired
    private CctVillageMaintainServiceImpl cctVillageMaintainService;
    /**
     * 查询维修记录
     * 
     * @param id 维修记录ID
     * @return 维修记录
     */
    @Override
    public CctMaintainRecord selectCctMaintainRecordById(Long id)
    {
        return cctMaintainRecordMapper.selectCctMaintainRecordById(id);
    }

    /**
     * 查询维修记录列表
     * 
     * @param cctMaintainRecord 维修记录
     * @return 维修记录
     */
    @Override
    public List<CctVillageMaintain> selectCctMaintainRecordList(CctMaintainRecord cctMaintainRecord)
    {
        return cctMaintainRecordMapper.selectCctMaintainRecordList(cctMaintainRecord);
    }

    /**
     * 新增维修记录
     * 
     * @param cctMaintainRecord 维修记录
     * @return 结果
     */
    @Override
    public int insertCctMaintainRecord(CctMaintainRecord cctMaintainRecord)
    {
        cctMaintainRecord.setCreateTime(DateUtils.getNowDate());
        CctVillageMaintain cctVillageMaintain = new CctVillageMaintain();
        cctVillageMaintain.setId(cctMaintainRecord.getMId());
        cctVillageMaintain.setStatus(2);
        cctVillageMaintainService.updateCctVillageMaintain(cctVillageMaintain);
        return cctMaintainRecordMapper.insertCctMaintainRecord(cctMaintainRecord);
    }

    /**
     * 修改维修记录
     * 
     * @param cctMaintainRecord 维修记录
     * @return 结果
     */
    @Override
    public int updateCctMaintainRecord(CctMaintainRecord cctMaintainRecord)
    {
        cctMaintainRecord.setUpdateTime(DateUtils.getNowDate());
        return cctMaintainRecordMapper.updateCctMaintainRecord(cctMaintainRecord);
    }

    /**
     * 删除维修记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctMaintainRecordByIds(String ids)
    {
        return cctMaintainRecordMapper.deleteCctMaintainRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除维修记录信息
     * 
     * @param id 维修记录ID
     * @return 结果
     */
    @Override
    public int deleteCctMaintainRecordById(Long id)
    {
        return cctMaintainRecordMapper.deleteCctMaintainRecordById(id);
    }
}
