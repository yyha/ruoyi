package com.ruoyi.app.service.wallet.impl;


import com.ruoyi.app.domain.task.CctTask;
import com.ruoyi.app.domain.task.CctUserTask;
import com.ruoyi.app.domain.wallet.CctMoneyIncome;
import com.ruoyi.app.mapper.task.CctTaskMapper;
import com.ruoyi.app.mapper.task.CctUserTaskMapper;
import com.ruoyi.app.mapper.wallet.CctMoneyIncomeMapper;
import com.ruoyi.app.service.wallet.ICctMoneyIncomeService;
import com.ruoyi.app.service.wallet.ICctUserMoneyService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-25
 */
@Service
public class CctMoneyIncomeServiceImpl implements ICctMoneyIncomeService {
    @Autowired
    private CctMoneyIncomeMapper cctMoneyIncomeMapper;
    /**
     * 村民任务记录
     */
    @Autowired
    private CctUserTaskMapper cctUserTaskMapper;
    /**
     * 任务记录
     */
    @Autowired
    private CctTaskMapper cctTaskMapper;


    @Autowired
    private ICctUserMoneyService userMoneyService;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public CctMoneyIncome selectCctMoneyIncomeById(Integer id) {
        return cctMoneyIncomeMapper.selectCctMoneyIncomeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param cctMoneyIncome 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CctMoneyIncome> selectCctMoneyIncomeList(CctMoneyIncome cctMoneyIncome) {
        return cctMoneyIncomeMapper.selectCctMoneyIncomeList(cctMoneyIncome);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param cctMoneyIncome 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCctMoneyIncome(CctMoneyIncome cctMoneyIncome) {
        cctMoneyIncome.setCreateTime(DateUtils.getNowDate());
        return cctMoneyIncomeMapper.insertCctMoneyIncome(cctMoneyIncome);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param cctMoneyIncome 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCctMoneyIncome(CctMoneyIncome cctMoneyIncome) {
        cctMoneyIncome.setUpdateTime(DateUtils.getNowDate());
        return cctMoneyIncomeMapper.updateCctMoneyIncome(cctMoneyIncome);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctMoneyIncomeByIds(String ids) {
        return cctMoneyIncomeMapper.deleteCctMoneyIncomeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCctMoneyIncomeById(Integer id) {
        return cctMoneyIncomeMapper.deleteCctMoneyIncomeById(id);
    }

    /**
     * 添加收入记录
     *
     * @param id 村民任务id
     * @return
     */
    @Override
    public int addIncomeAndModifyThePurse(Integer id) {

//        1.村民任务id先查询,拿到单条任务对象
        CctUserTask userTask = cctUserTaskMapper.selectCctUserTaskById(Long.valueOf(id));

//        2.取村民任务对象中的  task_id  拿到任务
            CctTask cctTask = cctTaskMapper.selectCctTaskById(userTask.getTaskId().toString());

//        如果发起延期获取奖励将会减少10%
        if (userTask.getApplyType() == 1) {
            //10%是定值 换算小数 0.1
            BigDecimal rate =new BigDecimal("0.1");

            //计算   并  保存两位小数
            BigDecimal money = cctTask.getMoney().subtract(cctTask.getMoney().multiply(rate)).setScale(2, BigDecimal.ROUND_HALF_UP);

            //创建BigDecimal类型  并存入
            cctTask.setMoney(money);
        }
//        3.创建收入对象,赋值并填入数据.
            CctMoneyIncome moneyIncome = new CctMoneyIncome();
            moneyIncome.setIncomeMoney(cctTask.getMoney());
            moneyIncome.setTId(cctTask.getTId().intValue());
            moneyIncome.setUId(userTask.getUserId().intValue());
//        4.插入数据
            cctMoneyIncomeMapper.insertCctMoneyIncome(moneyIncome);
//        修改金额
            userMoneyService.updateCctUserMoney(userTask, cctTask);

        return 0;
    }
}
