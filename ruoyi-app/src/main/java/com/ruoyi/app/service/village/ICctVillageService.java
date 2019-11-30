package com.ruoyi.app.service.village;

import com.ruoyi.app.domain.village.CctVillage;
import java.util.List;

/**
 * 村庄Service接口
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
public interface ICctVillageService 
{
    /**
     * 查询村庄
     * 
     * @param vId 村庄ID
     * @return 村庄
     */
    public CctVillage selectCctVillageById(Long vId);

    /**
     * 查询村庄列表
     * 
     * @param cctVillage 村庄
     * @return 村庄集合
     */
    public List<CctVillage> selectCctVillageList(CctVillage cctVillage);

    /**
     * 新增村庄
     * 
     * @param cctVillage 村庄
     * @return 结果
     */
    public int insertCctVillage(CctVillage cctVillage);

    /**
     * 修改村庄
     * 
     * @param cctVillage 村庄
     * @return 结果
     */
    public int updateCctVillage(CctVillage cctVillage);

    /**
     * 批量删除村庄
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctVillageByIds(String ids);

    /**
     * 删除村庄信息
     * 
     * @param vId 村庄ID
     * @return 结果
     */
    public int deleteCctVillageById(Long vId);

    /**
     * 查询村庄热度排行榜
     * @return
     */
    List<CctVillage> getHotVillage();

    /**
     * 修改村庄推荐
     * false=0  true=1
     *
     */
    int updateRecommend(Integer vId);

    /**
     * 查询推荐村子展示
     * @return 村子List集合
     */
    List<CctVillage> selectRecommendVillage();
}
