package com.ruoyi.app.controller.wallet;


import com.ruoyi.app.domain.wallet.CctMoneyIncome;
import com.ruoyi.app.service.wallet.ICctMoneyIncomeService;
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
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2019-11-25
 */
@Controller
@RequestMapping("/app/income")
public class CctMoneyIncomeController extends BaseController
{
    private String prefix = "system/income";

    @Autowired
    private ICctMoneyIncomeService cctMoneyIncomeService;

    @RequiresPermissions("system:income:view")
    @GetMapping()
    public String income()
    {
        return prefix + "/income";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:income:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctMoneyIncome cctMoneyIncome)
    {
        startPage();
        List<CctMoneyIncome> list = cctMoneyIncomeService.selectCctMoneyIncomeList(cctMoneyIncome);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:income:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctMoneyIncome cctMoneyIncome)
    {
        List<CctMoneyIncome> list = cctMoneyIncomeService.selectCctMoneyIncomeList(cctMoneyIncome);
        ExcelUtil<CctMoneyIncome> util = new ExcelUtil<CctMoneyIncome>(CctMoneyIncome.class);
        return util.exportExcel(list, "income");
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
    @RequiresPermissions("system:income:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctMoneyIncome cctMoneyIncome)
    {
        return toAjax(cctMoneyIncomeService.insertCctMoneyIncome(cctMoneyIncome));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        CctMoneyIncome cctMoneyIncome = cctMoneyIncomeService.selectCctMoneyIncomeById(id);
        mmap.put("cctMoneyIncome", cctMoneyIncome);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:income:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctMoneyIncome cctMoneyIncome)
    {
        return toAjax(cctMoneyIncomeService.updateCctMoneyIncome(cctMoneyIncome));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:income:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cctMoneyIncomeService.deleteCctMoneyIncomeByIds(ids));
    }
}
