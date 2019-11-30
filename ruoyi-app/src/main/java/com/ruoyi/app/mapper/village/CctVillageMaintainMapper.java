package com.ruoyi.app.mapper.village;

import com.ruoyi.app.domain.village.CctMaintainRecord;
import com.ruoyi.app.domain.village.CctVillageMaintain;
import java.util.List;

/**
 * 村维修Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
public interface CctVillageMaintainMapper 
{
    /**
     * 查询村维修
     * 
     * @param id 村维修ID
     * @return 村维修
     */
    public CctVillageMaintain selectCctVillageMaintainById(Long id);

    /**
     * 查询村维修列表
     * 
     * @param cctVillageMaintain 村维修
     * @return 村维修集合
     */
    public List<CctVillageMaintain> selectCctVillageMaintainList(CctVillageMaintain cctVillageMaintain);

    /**
     * 新增村维修
     * 
     * @param cctVillageMaintain 村维修
     * @return 结果
     */
    public int insertCctVillageMaintain(CctVillageMaintain cctVillageMaintain);

    /**
     * 修改村维修
     * 
     * @param cctVillageMaintain 村维修
     * @return 结果
     */
    public int updateCctVillageMaintain(CctVillageMaintain cctVillageMaintain);

    /**
     * 删除村维修
     * 
     * @param id 村维修ID
     * @return 结果
     */
    public int deleteCctVillageMaintainById(Long id);

    /**
     * 批量删除村维修
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctVillageMaintainByIds(String[] ids);

    /**
     * 添加用户维修记录
     */
    int addUserRepair(CctMaintainRecord cctMaintainRecord);
}
