package com.ruoyi.app.mapper.task;

import com.ruoyi.app.domain.task.CctUserTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 领取任务Mapper接口
 *
 * @author ruoyi
 * @date 2019-11-11
 */
public interface CctUserTaskMapper {
    /**
     * 查询领取任务
     *
     * @param id 领取任务ID
     * @return 领取任务
     */
    public CctUserTask selectCctUserTaskById(Long id);

    /**
     * 查询任务加入的用户数
     * @param id
     * @return
     */
    public Integer selectCCtTaskJoinUserNum(@Param("id") Long id);

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
    public int insertCctUserTask(CctUserTask cctUserTask);

    /**
     * 修改领取任务
     *
     * @param cctUserTask 领取任务
     * @return 结果
     */
    public int updateCctUserTask(CctUserTask cctUserTask);

    /**
     * 删除领取任务
     *
     * @param userId 领取任务ID
     * @return 结果
     */
    public int deleteCctUserTaskById(Long userId);

    /**
     * 批量删除领取任务
     *
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctUserTaskByIds(String[] userIds);

    /**
     * 查询提出延迟申请的任务记录
     * @param userTask
     * @return
     */
    List<CctUserTask> selectDelayTaskList(CctUserTask userTask);

    /**
     * 根据任务id查询领取任务
     * @param cctUserTask
     */
    CctUserTask selectCctUserTaskByTaskId(CctUserTask cctUserTask);

    /**
     * 查询用户领取任务状态数量
     *
     * @param userId 领取任务ID
     * @return 结果
     */
    Map selectUserTaskStatusCount(Long userId);
}
