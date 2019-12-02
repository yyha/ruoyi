package com.ruoyi.app.mapper.village;


import com.ruoyi.app.domain.village.CctVillage;

import java.util.List;

/**
 * 村庄Mapper接口
 *
 * @author ruoyi
 * @date 2019-11-11
 */
public interface CctVillageMapper {
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
     * 村民对应的村庄
     *
     * @param userId 用户id
     * @return 村庄名字
     */
    public String correspondenceVillager(Integer userId);

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
     * 删除村庄
     *
     * @param vId 村庄ID
     * @return 结果
     */
    public int deleteCctVillageById(Long vId);

    /**
     * 批量删除村庄
     *
     * @param vIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctVillageByIds(String[] vIds);

    /**
     * 查询村庄热度排行榜
     *
     * @return
     */
    List<CctVillage> getHotVillage();

    /**
     * 修改村庄推荐
     */
    int updateRecommend(CctVillage cctVillage);

    /**
     * 查询推荐村子展示
     * @return 村子List集合
     */
    List<CctVillage> selectRecommendVillage();
}
