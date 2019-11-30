package com.ruoyi.app.service.task.impl;

import java.util.List;

import com.ruoyi.app.domain.task.CctUserScore;
import com.ruoyi.app.mapper.task.CctUserScoreMapper;
import com.ruoyi.app.service.task.ICctUserScoreService;
import com.ruoyi.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户信用分数Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Service
public class CctUserScoreServiceImpl implements ICctUserScoreService
{
    @Autowired
    private CctUserScoreMapper cctUserScoreMapper;

    /**
     * 查询用户信用分数
     * 
     * @param id 用户信用分数ID
     * @return 用户信用分数
     */
    @Override
    public CctUserScore selectCctUserScoreById(Long id)
    {
        CctUserScore userScore = cctUserScoreMapper.selectCctUserScoreById(id);
        if(userScore == null){
            throw new BusinessException(String.format("id为%1$s的积分记录不存在",id));
        }
        return userScore;
    }

    /**
     * 查询用户信用分数列表
     * 
     * @param cctUserScore 用户信用分数
     * @return 用户信用分数
     */
    @Override
    public List<CctUserScore> selectCctUserScoreList(CctUserScore cctUserScore)
    {
        return cctUserScoreMapper.selectCctUserScoreList(cctUserScore);
    }

    /**
     * 新增用户信用分数
     * 
     * @param cctUserScore 用户信用分数
     * @return 结果
     */
    @Override
    public int insertCctUserScore(CctUserScore cctUserScore)
    {
        return cctUserScoreMapper.insertCctUserScore(cctUserScore);
    }

    /**
     * 修改用户信用分数
     * 
     * @param cctUserScore 用户信用分数
     * @return 结果
     */
    @Override
    public int updateCctUserScore(CctUserScore cctUserScore)
    {
        if(cctUserScore.getScore() < 0 || cctUserScore.getScore() > 100){
            throw new BusinessException(String.format("%1$s不在0-100范围内", cctUserScore.getScore()));
        }
        return cctUserScoreMapper.updateCctUserScore(cctUserScore);
    }

    /**
     * 删除用户信用分数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctUserScoreByIds(String ids)
    {
        return cctUserScoreMapper.deleteCctUserScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信用分数信息
     * 
     * @param id 用户信用分数ID
     * @return 结果
     */
    @Override
    public int deleteCctUserScoreById(Long id)
    {
        return cctUserScoreMapper.deleteCctUserScoreById(id);
    }
}
