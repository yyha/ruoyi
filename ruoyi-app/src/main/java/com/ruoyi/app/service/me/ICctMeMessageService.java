package com.ruoyi.app.service.me;

import com.ruoyi.app.domain.me.CctMeMessage;

import java.util.List;

/**
 * Service接口
 * 
 * @author ruoyi
 * @date 2019-11-20
 */
public interface ICctMeMessageService 
{
    /**
     * 查询
     * 
     * @param id ID
     * @return
     */
    public CctMeMessage selectCctMeMessageById(Long id);

    /**
     * 判断类别单条查询
     *
     * @param cctMeMessage ID
     * @return
     */
    public CctMeMessage determineTheCategorySingleQuery(CctMeMessage cctMeMessage);

    /**
     * 查询列表
     * 
     * @param cctMeMessage
     * @return 集合
     */
    public List<CctMeMessage> selectCctMeMessageList(CctMeMessage cctMeMessage);

    /**
     * 查询未读数量
     *
     * @param userId 用户id
     * @return 数量
     */
    public int selectNreadCount(Integer userId);
    /**
     * 新增
     * 
     * @param cctMeMessage
     * @return 结果
     */
    public int insertCctMeMessage(CctMeMessage cctMeMessage);

    /**
     * 修改
     * 
     * @param cctMeMessage
     * @return 结果
     */
    public int updateCctMeMessage(CctMeMessage cctMeMessage);

    /**
     * 批量删除
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctMeMessageByIds(String ids);

    /**
     * 删除  信息
     * 
     * @param id ID
     * @return 结果
     */
    public int deleteCctMeMessageById(Long id);

    /**
     * 删除  信息
     *
     * @param id ID
     * @return 结果
     */
    public int deleteCctMeMessageUserId(Long id);
}
