package com.ruoyi.app.controller.sys;

import java.util.List;

import com.ruoyi.app.domain.sys.CctVillageImage;
import com.ruoyi.app.service.sys.ICctVillageImageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/system/image")
public class CctVillageImageController extends BaseController {
    private String prefix = "sys";

    @Autowired
    private ICctVillageImageService cctVillageImageService;

    @RequiresPermissions("system:image:view")
    @GetMapping()
    public String image() {
        return prefix + "/image";
    }

    /**
     * 查询【请填写功能名称】列表
     */
//    @RequiresPermissions("system:image:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctVillageImage cctVillageImage) {
        startPage();
        List<CctVillageImage> list = cctVillageImageService.selectCctVillageImageList(cctVillageImage);
        list.parallelStream().forEach(img -> {
            String[] images = img.getImageUrl().split(",");
            img.setImages(images);
        });
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:image:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctVillageImage cctVillageImage) {
        List<CctVillageImage> list = cctVillageImageService.selectCctVillageImageList(cctVillageImage);
        ExcelUtil<CctVillageImage> util = new ExcelUtil<CctVillageImage>(CctVillageImage.class);
        return util.exportExcel(list, "image");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:image:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctVillageImage cctVillageImage) {
        return toAjax(cctVillageImageService.insertCctVillageImage(cctVillageImage));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        CctVillageImage cctVillageImage = cctVillageImageService.selectCctVillageImageById(id);
        mmap.put("id", cctVillageImage.getId());
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:image:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctVillageImage cctVillageImage) {
        return toAjax(cctVillageImageService.updateCctVillageImage(cctVillageImage));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:image:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cctVillageImageService.deleteCctVillageImageByIds(ids));
    }
}
