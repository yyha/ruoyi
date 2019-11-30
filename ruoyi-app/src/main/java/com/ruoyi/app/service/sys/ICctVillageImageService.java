package com.ruoyi.app.service.sys;

import com.ruoyi.app.domain.sys.CctVillageImage;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-11-27
 */
public interface ICctVillageImageService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CctVillageImage selectCctVillageImageById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cctVillageImage 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CctVillageImage> selectCctVillageImageList(CctVillageImage cctVillageImage);

    /**
     * 新增【请填写功能名称】
     * 
     * @param cctVillageImage 【请填写功能名称】
     * @return 结果
     */
    public int insertCctVillageImage(CctVillageImage cctVillageImage);

    /**
     * 修改【请填写功能名称】
     * 
     * @param cctVillageImage 【请填写功能名称】
     * @return 结果
     */
    public int updateCctVillageImage(CctVillageImage cctVillageImage);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCctVillageImageByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCctVillageImageById(Long id);
}
