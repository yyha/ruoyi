package com.ruoyi.app.controller.wallet;


import com.ruoyi.app.domain.wallet.CctUserMoney;
import com.ruoyi.app.service.wallet.ICctUserMoneyService;
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
@RequestMapping("/system/money")
public class CctUserMoneyController extends BaseController
{
    private String prefix = "system/money";

    @Autowired
    private ICctUserMoneyService cctUserMoneyService;

    @RequiresPermissions("system:money:view")
    @GetMapping()
    public String money()
    {
        return prefix + "/money";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:money:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctUserMoney cctUserMoney)
    {
        startPage();
        List<CctUserMoney> list = cctUserMoneyService.selectCctUserMoneyList(cctUserMoney);
        return getDataTable(list);
    }

    /**
     * 查询 我的余额
     */
    @RequiresPermissions("system:money:list")
    @GetMapping("/userMoney/{id}")
    @ResponseBody
    public AjaxResult userMoney(@PathVariable("id") Integer id)
    {
        CctUserMoney cctUserMoney = cctUserMoneyService.selectCctUserMoneyUserId(id);
        return AjaxResult.success(cctUserMoney);
    }



    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:money:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctUserMoney cctUserMoney)
    {
        List<CctUserMoney> list = cctUserMoneyService.selectCctUserMoneyList(cctUserMoney);
        ExcelUtil<CctUserMoney> util = new ExcelUtil<CctUserMoney>(CctUserMoney.class);
        return util.exportExcel(list, "money");
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
    @RequiresPermissions("system:money:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctUserMoney cctUserMoney)
    {
//        return toAjax(cctUserMoneyService.insertCctUserMoney(cctUserMoney));
        return null;
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        CctUserMoney cctUserMoney = cctUserMoneyService.selectCctUserMoneyById(id);
        mmap.put("cctUserMoney", cctUserMoney);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:money:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctUserMoney cctUserMoney)
    {
//        return toAjax(cctUserMoneyService.updateCctUserMoney(cctUserMoney));
        return null;
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:money:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cctUserMoneyService.deleteCctUserMoneyByIds(ids));
    }
}
