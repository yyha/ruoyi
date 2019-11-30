package com.ruoyi.app.service.task;

import com.ruoyi.app.domain.task.CctUserTask;
import com.ruoyi.common.core.domain.AjaxResult;

import java.util.List;
import java.util.Map;

/**
 * 领取任务Service接口
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
public interface ICctUserTaskService 
{
    /**
     * 查询领取任务
     * 
     * @param id 领取任务ID
     * @return 领取任务
     */
    public CctUserTask selectCctUserTaskById(Long id);

    /**
     * 查询领取任务列表
     * 
     * @param cctUserTask 领取任务
     * @return 领取任务集合
     */
    public List<CctUserTask> selectCctUserTaskList(CctUserTask cctUserTask);

    /**
     * 新增领取任务
     * 
     * @param cctUserTask 领取任务
     * @return 结果
     */
    public AjaxResult insertCctUserTask(CctUserTask cctUserTask);

    /**
     * 修改领取任务
     * 
     * @param cctUserTask 领取任务
     * @return 结果
     */
    public int updateCctUserTask(CctUserTask cctUserTask);

    /**
     * 批量删除领取任务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctUserTaskByIds(String ids);

    /**
     * 删除领取任务信息
     * 
     * @param userId 领取任务ID
     * @return 结果
     */
    public int deleteCctUserTaskById(Long userId);

    /**
     * 查询提出延迟申请的任务记录
     * @param userTask
     * @return
     */
    List<CctUserTask> selectDelayTaskList(CctUserTask userTask);

    /**
     * 审批延迟申请
     * @param userTask
     * @return
     */
    int changeStatus(CctUserTask userTask);

    /**
     * 查询用户领取任务状态数量
     *
     * @param userId 领取任务ID
     * @return 结果
     */
    Map selectUserTaskStatusCount(Long userId);
}
