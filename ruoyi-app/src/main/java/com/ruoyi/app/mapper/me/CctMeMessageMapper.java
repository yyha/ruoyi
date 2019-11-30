package com.ruoyi.app.mapper.me;

import com.ruoyi.app.domain.me.CctMeMessage;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-20
 */
public interface CctMeMessageMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CctMeMessage selectCctMeMessageById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cctMeMessage 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CctMeMessage> selectCctMeMessageList(CctMeMessage cctMeMessage);

    /**
     * 新增【请填写功能名称】
     * 
     * @param cctMeMessage 【请填写功能名称】
     * @return 结果
     */
    public int insertCctMeMessage(CctMeMessage cctMeMessage);

    /**
     * 修改【请填写功能名称】
     * 
     * @param cctMeMessage 【请填写功能名称】
     * @return 结果
     */
    public int updateCctMeMessage(CctMeMessage cctMeMessage);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCctMeMessageById(Long id);

    /**
     * 删除  根据user_id删除数据
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCctMeMessageUserId(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctMeMessageByIds(String[] ids);
}
