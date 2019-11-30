package com.ruoyi.app.service.user.impl;

import java.util.List;

import com.ruoyi.app.domain.task.CctUserScore;
import com.ruoyi.app.service.task.ICctUserScoreService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.app.domain.user.CctUserAuth;
import com.ruoyi.app.mapper.user.CctUserAuthMapper;
import com.ruoyi.app.service.user.ICctUserAuthService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户实名认证Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Service
public class CctUserAuthServiceImpl implements ICctUserAuthService
{
    @Autowired
    private CctUserAuthMapper cctUserAuthMapper;

    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private ICctUserScoreService cctUserScoreService;
    /**
     * 查询用户实名认证
     * 
     * @param id 用户实名认证ID
     * @return 用户实名认证
     */
    @Override
    public CctUserAuth selectCctUserAuthById(Long id)
    {
        return cctUserAuthMapper.selectCctUserAuthById(id);
    }

    /**
     * 查询用户实名认证列表
     * 
     * @param cctUserAuth 用户实名认证
     * @return 用户实名认证
     */
    @Override
    public List<CctUserAuth> selectCctUserAuthList(CctUserAuth cctUserAuth)
    {
        return cctUserAuthMapper.selectCctUserAuthList(cctUserAuth);
    }

    /**
     * 新增用户实名认证
     * 
     * @param cctUserAuth 用户实名认证
     * @return 结果
     */
    @Override
    public int insertCctUserAuth(CctUserAuth cctUserAuth)
    {
        SysUser user = ShiroUtils.getSysUser();
        cctUserAuth.setUId(user.getUserId());
        cctUserAuth.setCreateTime(DateUtils.getNowDate());
        cctUserAuthMapper.insertCctUserAuth(cctUserAuth);

        //初始化用户分数表
        CctUserScore userScore = new CctUserScore(user.getUserId(),0L);
        cctUserScoreService.insertCctUserScore(userScore);

        user.setIsauth(true);
        user.setvId(cctUserAuth.getVId());
        return iSysUserService.updateUserInfo(user);
    }

    /**
     * 修改用户实名认证
     * 
     * @param cctUserAuth 用户实名认证
     * @return 结果
     */
    @Override
    public int updateCctUserAuth(CctUserAuth cctUserAuth)
    {
        cctUserAuth.setUpdateTime(DateUtils.getNowDate());
        return cctUserAuthMapper.updateCctUserAuth(cctUserAuth);
    }

    /**
     * 删除用户实名认证对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctUserAuthByIds(String ids)
    {
        return cctUserAuthMapper.deleteCctUserAuthByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户实名认证信息
     * 
     * @param id 用户实名认证ID
     * @return 结果
     */
    @Override
    public int deleteCctUserAuthById(Long id)
    {
        return cctUserAuthMapper.deleteCctUserAuthById(id);
    }
}
