package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公告 数据层
 * 
 * @author ruoyi
 */
public interface SysNoticeMapper
{


    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 查询公告
     *
     * @param noticeId 公告信息
     * @return 对象
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int insertNotice(SysNotice notice);

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int updateNotice(SysNotice notice);

    /**
     * 批量删除公告
     * 
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String[] noticeIds);


    /**
     * 新增用户与公告 中间表
     *
     * cctUserNotice 用户与公告 中间表
     * @return 结果
     */
    public int insertCctUserNotice(@Param("uId") Long uId,@Param("noticeId") Long noticeId);

    /**
     * 批量 用户与公告 中间表
     *
     * @param noticeId 需要删除的数据userID
     * @return 结果
     */
    public int deleteCctUserNoticeIds(String[] noticeId);
}