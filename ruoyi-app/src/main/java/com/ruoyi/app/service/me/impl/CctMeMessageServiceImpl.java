package com.ruoyi.app.service.me.impl;

import com.ruoyi.app.domain.me.CctMeMessage;
import com.ruoyi.app.domain.me.CctUserNotice;
import com.ruoyi.app.mapper.me.CctMeMessageMapper;
import com.ruoyi.app.mapper.me.CctUserNoticeMapper;
import com.ruoyi.app.service.me.ICctMeMessageService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.mapper.SysNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-20
 */
@Service
public class CctMeMessageServiceImpl implements ICctMeMessageService
{
    @Autowired
    private CctMeMessageMapper cctMeMessageMapper;
    @Autowired
    private SysNoticeMapper sysNoticeMapper;
    @Autowired
    private  CctUserNoticeMapper cctUserNoticeMapper;

    /**
     * 查询
     * 
     * @param id ID
     * @return
     */
    @Override
    public CctMeMessage selectCctMeMessageById(Long id)
    {
        return cctMeMessageMapper.selectCctMeMessageById(id);
    }

    /**
     * 判断类别   单条查询
     *
     * @param cctMeMessage ID
     * @return
     */
    @Override
    public CctMeMessage determineTheCategorySingleQuery(CctMeMessage cctMeMessage) {
        //类别  1 ：个人消息 2 : 平台消息
        if(cctMeMessage.getSource()==1){
            //修改 未读状态  是否已读，Y是 N否
            CctMeMessage message = new CctMeMessage();
            message.setId(cctMeMessage.getId());
            message.setIsread('Y');
            cctMeMessageMapper.updateCctMeMessage(message);
            return cctMeMessageMapper.selectCctMeMessageById(cctMeMessage.getId());
        }else if(cctMeMessage.getSource()==2){
            SysNotice sysNotice = sysNoticeMapper.selectNoticeById(cctMeMessage.getId());
            cctMeMessage.setId(sysNotice.getNoticeId());
            cctMeMessage.setTitle(sysNotice.getNoticeTitle());
            cctMeMessage.setContent(sysNotice.getNoticeContent());
            cctMeMessage.setSendTime(sysNotice.getCreateTime());
            //修改中间表   未读状态   是否已读，Y是 N否
            CctUserNotice userNotice = new CctUserNotice();
            userNotice.setIsread('Y');
            //无法获得中间表id只能根据  u_id	notice_id
            userNotice.setUId(cctMeMessage.getUserId());
            userNotice.setNoticeId(cctMeMessage.getId());
            cctUserNoticeMapper.updateCctUserNoticeUserIdNoticeId(userNotice);
            return cctMeMessage;
        }
        return null;
    }

    /**
     * 查询列表
     * 
     * @param cctMeMessage
     * @return
     */
    @Override
    public List<CctMeMessage> selectCctMeMessageList(CctMeMessage cctMeMessage)
    {
        return cctMeMessageMapper.selectCctMeMessageList(cctMeMessage);
    }

    /**
     * 新增
     * 
     * @param cctMeMessage
     * @return 结果
     */
    @Override
    public int insertCctMeMessage(CctMeMessage cctMeMessage)
    {
        return cctMeMessageMapper.insertCctMeMessage(cctMeMessage);
    }

    /**
     * 修改
     * 
     * @param cctMeMessage
     * @return 结果
     */
    @Override
    public int updateCctMeMessage(CctMeMessage cctMeMessage)
    {
        return cctMeMessageMapper.updateCctMeMessage(cctMeMessage);
    }

    /**
     * 删除对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctMeMessageByIds(String ids)
    {
        return cctMeMessageMapper.deleteCctMeMessageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除信息
     * 
     * @param id ID
     * @return 结果
     */
    @Override
    public int deleteCctMeMessageById(Long id)
    {
        return cctMeMessageMapper.deleteCctMeMessageById(id);
    }

    /**
     * 删除  公告和个人
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public int deleteCctMeMessageUserId(Long id)
    {
//        删除用户与公告 中间表对象
        cctUserNoticeMapper.deleteCctUserNoticeUserId(id);
        //删除  个人表中的数据
        return cctMeMessageMapper.deleteCctMeMessageUserId(id);
    }
}
