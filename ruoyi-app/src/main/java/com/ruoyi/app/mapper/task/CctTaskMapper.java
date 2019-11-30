package com.ruoyi.app.mapper.task;

import com.ruoyi.app.domain.task.CctTask;
import java.util.List;

/**
 * 任务Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
public interface CctTaskMapper 
{
    /**
     * 查询任务
     * 
     * @param tId 任务ID
     * @return 任务
     */
    public CctTask selectCctTaskById(String tId);

    /**
     * 查询任务列表
     * 
     * @param cctTask 任务
     * @return 任务集合
     */
    public List<CctTask> selectCctTaskList(CctTask cctTask);

    /**
     * 新增任务
     * 
     * @param cctTask 任务
     * @return 结果
     */
    public int insertCctTask(CctTask cctTask);

    /**
     * 修改任务
     * 
     * @param cctTask 任务
     * @return 结果
     */
    public int updateCctTask(CctTask cctTask);

    /**
     * 删除任务
     * 
     * @param tId 任务ID
     * @return 结果
     */
    public int deleteCctTaskById(Long tId);

    /**
     * 批量删除任务
     * 
     * @param tIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctTaskByIds(String[] tIds);
}
