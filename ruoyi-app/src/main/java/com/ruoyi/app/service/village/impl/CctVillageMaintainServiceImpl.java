package com.ruoyi.app.service.village.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.app.domain.village.CctVillageMaintain;
import com.ruoyi.app.mapper.village.CctVillageMaintainMapper;
import com.ruoyi.app.service.village.ICctVillageMaintainService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 村维修Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Service
public class CctVillageMaintainServiceImpl implements ICctVillageMaintainService
{
    @Autowired
    private CctVillageMaintainMapper cctVillageMaintainMapper;

    /**
     * 查询村维修
     * 
     * @param id 村维修ID
     * @return 村维修
     */
    @Override
    public CctVillageMaintain selectCctVillageMaintainById(Long id)
    {
        return cctVillageMaintainMapper.selectCctVillageMaintainById(id);
    }

    /**
     * 查询村维修列表
     * 
     * @param cctVillageMaintain 村维修
     * @return 村维修
     */
    @Override
    public List<CctVillageMaintain> selectCctVillageMaintainList(CctVillageMaintain cctVillageMaintain)
    {
        return cctVillageMaintainMapper.selectCctVillageMaintainList(cctVillageMaintain);
    }

    /**
     * 新增村维修
     * 
     * @param cctVillageMaintain 村维修
     * @return 结果
     */
    @Override
    public int insertCctVillageMaintain(CctVillageMaintain cctVillageMaintain)
    {
        SysUser user = ShiroUtils.getSysUser();
        cctVillageMaintain.setUId(user.getUserId());
        cctVillageMaintain.setCreateTime(DateUtils.getNowDate());
        return cctVillageMaintainMapper.insertCctVillageMaintain(cctVillageMaintain);
    }

    /**
     * 修改村维修
     * 
     * @param cctVillageMaintain 村维修
     * @return 结果
     */
    @Override
    public int updateCctVillageMaintain(CctVillageMaintain cctVillageMaintain)
    {
        cctVillageMaintain.setUpdateTime(DateUtils.getNowDate());
        return cctVillageMaintainMapper.updateCctVillageMaintain(cctVillageMaintain);
    }

    /**
     * 删除村维修对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctVillageMaintainByIds(String ids)
    {
        return cctVillageMaintainMapper.deleteCctVillageMaintainByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除村维修信息
     * 
     * @param id 村维修ID
     * @return 结果
     */
    @Override
    public int deleteCctVillageMaintainById(Long id)
    {
        return cctVillageMaintainMapper.deleteCctVillageMaintainById(id);
    }
}
