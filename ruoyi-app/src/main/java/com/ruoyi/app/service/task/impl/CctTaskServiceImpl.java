package com.ruoyi.app.service.task.impl;

import com.ruoyi.app.mapper.task.CctUserTaskMapper;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.app.domain.task.CctTask;
import com.ruoyi.app.mapper.task.CctTaskMapper;
import com.ruoyi.app.service.task.ICctTaskService;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * 任务Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-11
 */
@Service
public class CctTaskServiceImpl implements ICctTaskService {
    @Autowired
    private CctTaskMapper cctTaskMapper;

    @Autowired
    private CctUserTaskMapper cctUserTaskMapper;

    /**
     * 查询任务
     *
     * @param tId 任务ID
     * @return 任务
     */
    @Override
    public CctTask selectCctTaskById(String tId) {
        CctTask cctTask = cctTaskMapper.selectCctTaskById(tId);
        //已加入人数
        Integer joinNum = cctUserTaskMapper.selectCCtTaskJoinUserNum(Long.valueOf(tId));
        //浏览量+1
        CctTask newTast = new CctTask();
        newTast.setTId(cctTask.getTId());
        newTast.setPageView(cctTask.getPageView()+1);
        cctTaskMapper.updateCctTask(newTast);
        cctTask.setJoinNum(joinNum);
        return cctTask;
    }

    /**
     * 查询任务列表
     *
     * @param cctTask 任务
     * @return 任务
     */
    @Override
    public List<CctTask> selectCctTaskList(CctTask cctTask) {
        List<CctTask> taskList = cctTaskMapper.selectCctTaskList(cctTask);
        taskList.parallelStream().forEach(task -> {
            //已加入人数
            Integer joinNum = cctUserTaskMapper.selectCCtTaskJoinUserNum(task.getTId());
            task.setJoinNum(joinNum);
            Optional<String> optional = Optional.ofNullable(task.getImage());
            if (optional.isPresent()) {
                task.setImage(optional.map(s -> s.split(",")[0]).orElse(null));
            }
        });
        return taskList;
    }

    /**
     * 新增任务
     *
     * @param cctTask 任务
     * @return 结果
     */
    @Override
    public int insertCctTask(CctTask cctTask) {
        cctTask.setCreateTime(DateUtils.getNowDate());
        cctTask.setPubdate(DateUtils.getNowDate());
        SysUser user = ShiroUtils.getSysUser();
        cctTask.setVId(user.getvId());
        return cctTaskMapper.insertCctTask(cctTask);
    }

    /**
     * 修改任务
     *
     * @param cctTask 任务
     * @return 结果
     */
    @Override
    public int updateCctTask(CctTask cctTask) {
        cctTask.setUpdateTime(DateUtils.getNowDate());
        return cctTaskMapper.updateCctTask(cctTask);
    }

    /**
     * 删除任务对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctTaskByIds(String ids) {
        return cctTaskMapper.deleteCctTaskByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除任务信息
     *
     * @param tId 任务ID
     * @return 结果
     */
    @Override
    public int deleteCctTaskById(Long tId) {
        return cctTaskMapper.deleteCctTaskById(tId);
    }
}
