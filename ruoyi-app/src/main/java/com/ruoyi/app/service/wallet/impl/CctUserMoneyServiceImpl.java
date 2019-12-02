package com.ruoyi.app.service.wallet.impl;


import com.ruoyi.app.domain.task.CctTask;
import com.ruoyi.app.domain.task.CctUserTask;
import com.ruoyi.app.domain.wallet.CctUserMoney;
import com.ruoyi.app.mapper.wallet.CctUserMoneyMapper;
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
public class CctUserMoneyServiceImpl implements ICctUserMoneyService 
{


    @Autowired
    private CctUserMoneyMapper cctUserMoneyMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public CctUserMoney selectCctUserMoneyById(Integer id)
    {
        return cctUserMoneyMapper.selectCctUserMoneyById(id);
    }

    /**
     *  根据用户id 查询 我的余额
     *
     * @param id 用户idID
     * @return 对象
     */
    @Override
    public CctUserMoney selectCctUserMoneyUserId(Integer id) {
        return cctUserMoneyMapper.selectCctUserMoneyByUserId(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cctUserMoney 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CctUserMoney> selectCctUserMoneyList(CctUserMoney cctUserMoney)
    {
        return cctUserMoneyMapper.selectCctUserMoneyList(cctUserMoney);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param id 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCctUserMoney(Integer id)
    {
        CctUserMoney cctUserMoney = new CctUserMoney();
        cctUserMoney.setUId(id);
        cctUserMoney.setCreateTime(DateUtils.getNowDate());
        if (cctUserMoney.getMoney()==null) {
            cctUserMoney.setMoney(BigDecimal.ZERO);
        }
        return cctUserMoneyMapper.insertCctUserMoney(cctUserMoney);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @return 结果
     */
    @Override
    public int updateCctUserMoney(CctUserTask userTask, CctTask task)
    {
        //
        CctUserMoney cctUserMoney = cctUserMoneyMapper.selectCctUserMoneyByUserId(userTask.getUserId().intValue());

        cctUserMoney.setMoney(cctUserMoney.getMoney().add(task.getMoney()));

        return cctUserMoneyMapper.updateCctUserMoney(cctUserMoney);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctUserMoneyByIds(String ids)
    {
        return cctUserMoneyMapper.deleteCctUserMoneyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCctUserMoneyById(Integer id)
    {
        return cctUserMoneyMapper.deleteCctUserMoneyById(id);
    }
}
