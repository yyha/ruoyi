package com.ruoyi.app.service.task.impl;

import com.ruoyi.app.domain.me.CctMeMessage;
import com.ruoyi.app.domain.task.CctTask;
import com.ruoyi.app.domain.task.CctUserTask;
import com.ruoyi.app.mapper.me.CctMeMessageMapper;
import com.ruoyi.app.mapper.task.CctTaskMapper;
import com.ruoyi.app.mapper.task.CctUserTaskMapper;
import com.ruoyi.app.service.task.ICctUserTaskService;
import com.ruoyi.app.service.wallet.ICctMoneyIncomeService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 领取任务Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-11
 */
@Service
public class CctUserTaskServiceImpl implements ICctUserTaskService {
    @Autowired
    private CctUserTaskMapper cctUserTaskMapper;

    @Autowired
    private CctTaskMapper cctTaskMapper;

    @Autowired
    private CctMeMessageMapper cctMeMessageMapper;

    @Autowired
    private ICctMoneyIncomeService cctMoneyIncomeService;

    /**
     * 查询领取任务
     *
     * @param id 领取任务ID
     * @return 领取任务
     */
    @Override
    public CctUserTask selectCctUserTaskById(Long id) {
        CctUserTask cctUserTask = cctUserTaskMapper.selectCctUserTaskById(id);
        Integer joinNum = cctUserTaskMapper.selectCCtTaskJoinUserNum(cctUserTask.getTaskId());
        cctUserTask.setJoinNum(joinNum);
        return cctUserTask;
    }

    /**
     * 查询领取任务列表
     *
     * @param cctUserTask 领取任务
     * @return 领取任务
     */
    @Override
    public List<CctUserTask> selectCctUserTaskList(CctUserTask cctUserTask) {
        return cctUserTaskMapper.selectCctUserTaskList(cctUserTask);
    }

    /**
     * 新增领取任务
     *
     * @param cctUserTask 领取任务
     * @return 结果
     */
    @Override
    public AjaxResult insertCctUserTask(CctUserTask cctUserTask) {
        SysUser user = ShiroUtils.getSysUser();
        cctUserTask.setUserId(user.getUserId());
        CctUserTask cctUserTask1 = cctUserTaskMapper.selectCctUserTaskByTaskId(cctUserTask);
        if (cctUserTask1 != null) {
            return new AjaxResult(AjaxResult.Type.ERROR, "不能重复领取");
        }
        Integer joinNum = cctUserTaskMapper.selectCCtTaskJoinUserNum(cctUserTask.getTaskId());
        CctTask cctTask = cctTaskMapper.selectCctTaskById(String.valueOf(cctUserTask.getTaskId()));
        if (joinNum >= cctTask.getPersonNum()) {
            return new AjaxResult(AjaxResult.Type.ERROR, "人数已满");
        }
        cctUserTask.setCreateTime(DateUtils.getNowDate());
        cctUserTaskMapper.insertCctUserTask(cctUserTask);

        //领取后发站内信
        CctMeMessage message = new CctMeMessage(
                user.getUserId(),
                "任务接受成功",
                String.format("您已成功接受编号为%1$s号订单，请及时处理，领取物料挣钱吧！！",cctTask.getTId()),
                DateUtils.getNowDate()
        );
        cctMeMessageMapper.insertCctMeMessage(message);

        return new AjaxResult(AjaxResult.Type.SUCCESS, "领取成功");
    }

    /**
     * 修改领取任务
     *
     * @param cctUserTask 领取任务
     * @return 结果
     */
    @Override
    public int updateCctUserTask(CctUserTask cctUserTask) {
        SysUser user = ShiroUtils.getSysUser();
        cctUserTask.setUserId(user.getUserId());
        //申请延期
        if (cctUserTask.getApplyType() == 1) {
            cctUserTask.setApplyType(1);
        }
        //申请取消
        if (cctUserTask.getApplyType() == 2) {
            cctUserTask.setApplyType(2);
        }
        return cctUserTaskMapper.updateCctUserTask(cctUserTask);
    }

    /**
     * 删除领取任务对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctUserTaskByIds(String ids) {
        return cctUserTaskMapper.deleteCctUserTaskByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除领取任务信息
     *
     * @param userId 领取任务ID
     * @return 结果
     */
    @Override
    public int deleteCctUserTaskById(Long userId) {
        return cctUserTaskMapper.deleteCctUserTaskById(userId);
    }

    /**
     * 查询提出延迟申请的任务记录
     *
     * @param userTask
     * @return
     */
    @Override
    public List<CctUserTask> selectDelayTaskList(CctUserTask userTask) {
        return cctUserTaskMapper.selectDelayTaskList(userTask);
    }

    @Override
    public int changeStatus(CctUserTask userTask) {
        //        添加收入记录  于  修改钱包金额
        if (userTask.getStatus()==4){

            cctMoneyIncomeService.addIncomeAndModifyThePurse(userTask.getId().intValue());
        }
        return cctUserTaskMapper.updateCctUserTask(userTask);
    }

    /**
     * 查询用户领取任务状态数量
     *
     * @param userId 领取任务ID
     * @return 结果
     */
    @Override
    public Map selectUserTaskStatusCount(Long userId) {

        return cctUserTaskMapper.selectUserTaskStatusCount(userId);
    }
}
