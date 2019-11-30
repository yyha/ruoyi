package com.ruoyi.app.service.user;

import com.ruoyi.app.domain.user.CctUserAuth;
import java.util.List;

/**
 * 用户实名认证Service接口
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
public interface ICctUserAuthService 
{
    /**
     * 查询用户实名认证
     * 
     * @param id 用户实名认证ID
     * @return 用户实名认证
     */
    public CctUserAuth selectCctUserAuthById(Long id);

    /**
     * 查询用户实名认证列表
     * 
     * @param cctUserAuth 用户实名认证
     * @return 用户实名认证集合
     */
    public List<CctUserAuth> selectCctUserAuthList(CctUserAuth cctUserAuth);

    /**
     * 新增用户实名认证
     * 
     * @param cctUserAuth 用户实名认证
     * @return 结果
     */
    public int insertCctUserAuth(CctUserAuth cctUserAuth);

    /**
     * 修改用户实名认证
     * 
     * @param cctUserAuth 用户实名认证
     * @return 结果
     */
    public int updateCctUserAuth(CctUserAuth cctUserAuth);

    /**
     * 批量删除用户实名认证
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctUserAuthByIds(String ids);

    /**
     * 删除用户实名认证信息
     * 
     * @param id 用户实名认证ID
     * @return 结果
     */
    public int deleteCctUserAuthById(Long id);
}
