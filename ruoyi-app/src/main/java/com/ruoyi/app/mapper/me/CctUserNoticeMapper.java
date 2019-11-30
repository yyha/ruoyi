package com.ruoyi.app.mapper.me;


import com.ruoyi.app.domain.me.CctUserNotice;

import java.util.List;

/**
 * 用户与公告 中间表Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-28
 */
public interface CctUserNoticeMapper 
{
    /**
     * 查询用户与公告 中间表
     * 
     * @param id 用户与公告 中间表ID
     * @return 用户与公告 中间表
     */
    public CctUserNotice selectCctUserNoticeById(Long id);

    /**
     * 查询用户与公告 中间表列表
     * 
     * @param cctUserNotice 用户与公告 中间表
     * @return 用户与公告 中间表集合
     */
    public List<CctUserNotice> selectCctUserNoticeList(CctUserNotice cctUserNotice);

    /**
     * 新增用户与公告 中间表
     * 
     * @param cctUserNotice 用户与公告 中间表
     * @return 结果
     */
    public int insertCctUserNotice(CctUserNotice cctUserNotice);

    /**
     * 修改用户与公告 中间表
     * 
     * @param cctUserNotice 用户与公告 中间表
     * @return 结果
     */
    public int updateCctUserNotice(CctUserNotice cctUserNotice);


    /**
     * 修改用户与公告 中间表
     *
     * @param cctUserNotice 用户与公告 中间表
     * @return 结果
     */
    public int updateCctUserNoticeUserIdNoticeId(CctUserNotice cctUserNotice);

    /**
     * 删除用户与公告 中间表
     * 
     * @param id 用户与公告 中间表ID
     * @return 结果
     */
    public int deleteCctUserNoticeById(Long id);

    /**
     * 删除用户与公告 中间表
     *
     * @param id 用户与公告 中间表ID
     * @return 结果
     */
    public int deleteCctUserNoticeUserId(Long id);

    /**
     * 批量删除用户与公告 中间表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctUserNoticeByIds(String[] ids);
}
