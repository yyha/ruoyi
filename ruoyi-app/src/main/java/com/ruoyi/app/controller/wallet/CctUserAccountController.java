package com.ruoyi.app.controller.wallet;


import com.ruoyi.app.domain.wallet.CctUserAccount;
import com.ruoyi.app.service.wallet.ICctUserAccountService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
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
@RequestMapping("/system/account")
public class CctUserAccountController extends BaseController
{
    private String prefix = "system/account";

    @Autowired
    private ICctUserAccountService cctUserAccountService;

    @RequiresPermissions("system:account:view")
    @GetMapping()
    public String account()
    {
        return prefix + "/account";
    }

    /**
     * 查询【请填写功能名称】列表
     */
//    @RequiresPermissions("system:account:list")
    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(CctUserAccount cctUserAccount)
    {
        cctUserAccount.setUId(Integer.valueOf(ShiroUtils.getUserId().toString()));
        List<CctUserAccount> list = cctUserAccountService.selectCctUserAccountList(cctUserAccount);
        return AjaxResult.success("success",list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:account:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctUserAccount cctUserAccount)
    {
        List<CctUserAccount> list = cctUserAccountService.selectCctUserAccountList(cctUserAccount);
        ExcelUtil<CctUserAccount> util = new ExcelUtil<CctUserAccount>(CctUserAccount.class);
        return util.exportExcel(list, "account");
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
    @RequiresPermissions("system:account:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctUserAccount cctUserAccount)
    {
        return toAjax(cctUserAccountService.insertCctUserAccount(cctUserAccount));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        CctUserAccount cctUserAccount = cctUserAccountService.selectCctUserAccountById(id);
        mmap.put("cctUserAccount", cctUserAccount);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:account:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctUserAccount cctUserAccount)
    {
        return toAjax(cctUserAccountService.updateCctUserAccount(cctUserAccount));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:account:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cctUserAccountService.deleteCctUserAccountByIds(ids));
    }
}
