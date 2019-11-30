package com.ruoyi.app.controller.rate;

import com.ruoyi.app.domain.rate.CctRate;
import com.ruoyi.app.service.rate.ICctRateService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 手续费 Controller
 * 
 * @author ruoyi
 * @date 2019-11-23
 */
@Controller
@RequestMapping("/rate")
public class CctRateController extends BaseController
{
    private String prefix = "rate";

    
    @Autowired
    private ICctRateService cctRateService;

    @RequiresPermissions("system:rate:view")
    @GetMapping()
    public String rate()
    {
        return prefix + "/rate";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:rate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctRate cctRate)
    {
        startPage();
        List<CctRate> list = cctRateService.selectCctRateList(cctRate);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:rate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctRate cctRate)
    {
        List<CctRate> list = cctRateService.selectCctRateList(cctRate);
        ExcelUtil<CctRate> util = new ExcelUtil<CctRate>(CctRate.class);
        return util.exportExcel(list, "rate");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:rate:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctRate cctRate)
    {
        return toAjax(cctRateService.insertCctRate(cctRate));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{rId}")
    public String edit(@PathVariable("rId") Integer rId, ModelMap mmap)
    {
        CctRate cctRate = cctRateService.selectCctRateById(rId);
        mmap.put("cctRate", cctRate);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:rate:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctRate cctRate)
    {
        return toAjax(cctRateService.updateCctRate(cctRate));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:rate:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cctRateService.deleteCctRateByIds(ids));
    }
}
