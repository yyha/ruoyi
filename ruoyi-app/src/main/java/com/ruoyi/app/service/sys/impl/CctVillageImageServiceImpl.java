package com.ruoyi.app.service.sys.impl;


import com.ruoyi.app.domain.sys.CctVillageImage;
import com.ruoyi.app.mapper.sys.CctVillageImageMapper;
import com.ruoyi.app.service.sys.ICctVillageImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-27
 */
@Service
public class CctVillageImageServiceImpl implements ICctVillageImageService
{
    @Autowired
    private CctVillageImageMapper cctVillageImageMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public CctVillageImage selectCctVillageImageById(Long id)
    {
        return cctVillageImageMapper.selectCctVillageImageById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cctVillageImage 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CctVillageImage> selectCctVillageImageList(CctVillageImage cctVillageImage)
    {
        return cctVillageImageMapper.selectCctVillageImageList(cctVillageImage);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param cctVillageImage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCctVillageImage(CctVillageImage cctVillageImage)
    {
        cctVillageImageMapper.deleteCctVillageImagesAll();
        return cctVillageImageMapper.insertCctVillageImage(cctVillageImage);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param cctVillageImage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCctVillageImage(CctVillageImage cctVillageImage)
    {
        return cctVillageImageMapper.updateCctVillageImage(cctVillageImage);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctVillageImageByIds(String ids)
    {
        return cctVillageImageMapper.deleteCctVillageImageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCctVillageImageById(Long id)
    {
        return cctVillageImageMapper.deleteCctVillageImageById(id);
    }
}
