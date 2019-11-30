package com.ruoyi.app.service.village.impl;

import java.util.List;

import com.ruoyi.app.domain.village.CctVillage;
import com.ruoyi.app.mapper.village.CctVillageMapper;
import com.ruoyi.app.service.village.ICctVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 村庄Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-11
 */
@Service
public class CctVillageServiceImpl implements ICctVillageService {
    @Autowired
    private CctVillageMapper cctVillageMapper;

    /**
     * 查询村庄
     *
     * @param vId 村庄ID
     * @return 村庄
     */
    @Override
    public CctVillage selectCctVillageById(Long vId) {
        return cctVillageMapper.selectCctVillageById(vId);
    }

    /**
     * 查询村庄列表
     *
     * @param cctVillage 村庄
     * @return 村庄
     */
    @Override
    public List<CctVillage> selectCctVillageList(CctVillage cctVillage) {
        return cctVillageMapper.selectCctVillageList(cctVillage);
    }

    /**
     * 新增村庄
     *
     * @param cctVillage 村庄
     * @return 结果
     */
    @Override
    public int insertCctVillage(CctVillage cctVillage) {
        return cctVillageMapper.insertCctVillage(cctVillage);
    }

    /**
     * 修改村庄
     *
     * @param cctVillage 村庄
     * @return 结果
     */
    @Override
    public int updateCctVillage(CctVillage cctVillage) {
        return cctVillageMapper.updateCctVillage(cctVillage);
    }

    /**
     * 删除村庄对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctVillageByIds(String ids) {
        return cctVillageMapper.deleteCctVillageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除村庄信息
     *
     * @param vId 村庄ID
     * @return 结果
     */
    @Override
    public int deleteCctVillageById(Long vId) {
        return cctVillageMapper.deleteCctVillageById(vId);
    }


    /**
     * 查询村庄热度排行榜
     *
     * @return
     */
    @Override
    public List<CctVillage> getHotVillage() {

        return cctVillageMapper.getHotVillage();
    }

    /**
     * 查询推荐村子展示
     *
     * @return 村子List集合
     */
    @Override
    public List<CctVillage> selectRecommendVillage() {
        return cctVillageMapper.selectRecommendVillage();
    }

    /**
     * 修改村庄推荐
     */
    @Override
    public int updateRecommend(Integer vId) {
        CctVillage cctVillage1 = cctVillageMapper.selectCctVillageById(Long.valueOf(vId));
        if (cctVillage1.getRecommend()) {
            cctVillage1.setRecommend(false);
        } else {
            cctVillage1.setRecommend(true);
        }
        return cctVillageMapper.updateRecommend(cctVillage1);
    }
}
