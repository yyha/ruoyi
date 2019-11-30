package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.SysNoticeMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.service.ISysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公告 服务层实现
 *
 * @author ruoyi
 * @date 2018-06-25
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService {
    @Autowired
    private SysNoticeMapper noticeMapper;
    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysNotice selectNoticeById(Long noticeId) {
        return noticeMapper.selectNoticeById(noticeId);
    }

    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice) {
        return noticeMapper.selectNoticeList(notice);
    }





    /**
     * 查询公告列表
     *
     * @param notice 公告信息
     * @return 公告集合
     */


    /**
     * 新增公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int insertNotice(SysNotice notice) {
        List<SysUser> sysUsers = userMapper.selectSysUsetList();
        //  添加公告
        noticeMapper.insertNotice(notice);
        new Thread(()->{
            //  添加我的消息中间表
            for (SysUser sysUser : sysUsers) {
                noticeMapper.insertCctUserNotice(sysUser.getUserId(),notice.getNoticeId());

            }
        }).start();


        return 1;
    }

    /**
     * 修改公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int updateNotice(SysNotice notice) {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除公告对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(String ids) {
        noticeMapper.deleteCctUserNoticeIds(Convert.toStrArray(ids));
        return noticeMapper.deleteNoticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 公告状态修改
     *
     * @param notice 角色信息
     * @return 结果
     */
    @Override
    public int changeStatus(SysNotice notice) {
        return noticeMapper.updateNotice(notice);
    }
}
