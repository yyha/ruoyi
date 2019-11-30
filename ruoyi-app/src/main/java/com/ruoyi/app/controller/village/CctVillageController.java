package com.ruoyi.app.controller.village;

import com.ruoyi.app.domain.village.CctVillage;
import com.ruoyi.app.service.village.ICctVillageService;
import io.swagger.annotations.ApiOperation;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 村庄Controller
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Controller
@RequestMapping("/village/village")
public class CctVillageController extends BaseController
{
    private String prefix = "village";

    @Autowired
    private ICctVillageService cctVillageService;

    @RequiresPermissions("system:village:view")
    @GetMapping()
    public String village()
    {
        return prefix + "/village";
    }

    /**
     * 查询村庄列表
     */
    @RequiresPermissions("system:village:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctVillage cctVillage)
    {
        startPage();
        List<CctVillage> list = cctVillageService.selectCctVillageList(cctVillage);
        return getDataTable(list);
    }

    /**
     * 导出村庄列表
     */
    @RequiresPermissions("system:village:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctVillage cctVillage)
    {
        List<CctVillage> list = cctVillageService.selectCctVillageList(cctVillage);
        ExcelUtil<CctVillage> util = new ExcelUtil<CctVillage>(CctVillage.class);
        return util.exportExcel(list, "village");
    }

    /**
     * 新增村庄
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存村庄
     */
    @RequiresPermissions("system:village:add")
    @Log(title = "村庄", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctVillage cctVillage)
    {
        return toAjax(cctVillageService.insertCctVillage(cctVillage));
    }

    /**
     * 修改村庄
     */
    @GetMapping("/edit/{vId}")
    public String edit(@PathVariable("vId") Long vId, ModelMap mmap)
    {
        CctVillage cctVillage = cctVillageService.selectCctVillageById(vId);
        mmap.put("cctVillage", cctVillage);
        return prefix + "/edit";
    }

    /**
     * 修改保存村庄
     */
    @RequiresPermissions("system:village:edit")
    @Log(title = "村庄", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctVillage cctVillage)
    {
        return toAjax(cctVillageService.updateCctVillage(cctVillage));
    }

    /**
     * 删除村庄
     */
    @RequiresPermissions("system:village:remove")
    @Log(title = "村庄", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cctVillageService.deleteCctVillageByIds(ids));
    }

    /**
     * 查询村庄热度排行榜
     * @return
     */
    @PostMapping( "/hot")
    @ResponseBody
    @ApiOperation("查询村庄热度排行榜")
    public AjaxResult hot()
    {
        return new AjaxResult(AjaxResult.Type.SUCCESS,"ok",cctVillageService.getHotVillage());
    }

    /**
     *添加推荐村庄
     *@return
     */
    @PostMapping("/updateRecommend")
    @ResponseBody
    public AjaxResult updateRecommend(Integer vId){
        return toAjax(cctVillageService.updateRecommend(vId));
    }

    /**
     * 查询推荐村子展示
     * @return 村子List集合
     */
    @PostMapping("/selectRecommendVillage")
    @ResponseBody
    public AjaxResult selectRecommendVillage() {
        List<CctVillage> list = cctVillageService.selectCctVillageList(new CctVillage());
        List<CctVillage> recommendList =  cctVillageService.selectRecommendVillage();
        Map resultMap = new HashMap(2);
        resultMap.put("nearVillage",list);
        resultMap.put("recommendVillage",recommendList);
        return  AjaxResult.success("ok",resultMap);
    }

}
