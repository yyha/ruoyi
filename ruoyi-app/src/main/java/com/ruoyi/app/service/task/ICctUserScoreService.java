package com.ruoyi.app.service.task;

import com.ruoyi.app.domain.task.CctUserScore;
import java.util.List;

/**
 * 用户信用分数Service接口
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
public interface ICctUserScoreService 
{
    /**
     * 查询用户信用分数
     * 
     * @param id 用户信用分数ID
     * @return 用户信用分数
     */
    public CctUserScore selectCctUserScoreById(Long id);

    /**
     * 查询用户信用分数列表
     * 
     * @param cctUserScore 用户信用分数
     * @return 用户信用分数集合
     */
    public List<CctUserScore> selectCctUserScoreList(CctUserScore cctUserScore);

    /**
     * 新增用户信用分数
     * 
     * @param cctUserScore 用户信用分数
     * @return 结果
     */
    public int insertCctUserScore(CctUserScore cctUserScore);

    /**
     * 修改用户信用分数
     * 
     * @param cctUserScore 用户信用分数
     * @return 结果
     */
    public int updateCctUserScore(CctUserScore cctUserScore);

    /**
     * 批量删除用户信用分数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctUserScoreByIds(String ids);

    /**
     * 删除用户信用分数信息
     * 
     * @param id 用户信用分数ID
     * @return 结果
     */
    public int deleteCctUserScoreById(Long id);
}
