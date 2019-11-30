package com.ruoyi.app.controller.wallet;


import com.ruoyi.app.domain.wallet.CctMoneyWithdrawal;
import com.ruoyi.app.service.wallet.ICctMoneyWithdrawalService;
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
 * 提现记录Controller
 *
 * @author ruoyi
 * @date 2019-11-25
 */
@Controller
@RequestMapping("/app/withdrawal")
public class CctMoneyWithdrawalController extends BaseController {
    private String prefix = "withdrawal";

    @Autowired
    private ICctMoneyWithdrawalService cctMoneyWithdrawalService;

    @RequiresPermissions("system:withdrawal:view")
    @GetMapping()
    public String withdrawal() {
        return prefix + "/withdrawal";
    }

    /**
     * 查询提现记录列表
     */
    @RequiresPermissions("system:withdrawal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctMoneyWithdrawal cctMoneyWithdrawal) {
        startPage();
        List<CctMoneyWithdrawal> list = cctMoneyWithdrawalService.selectCctMoneyWithdrawalList(cctMoneyWithdrawal);
        return getDataTable(list);
    }

    /**
     * 导出提现记录列表
     */
    @RequiresPermissions("system:withdrawal:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctMoneyWithdrawal cctMoneyWithdrawal) {
        List<CctMoneyWithdrawal> list = cctMoneyWithdrawalService.selectCctMoneyWithdrawalList(cctMoneyWithdrawal);
        ExcelUtil<CctMoneyWithdrawal> util = new ExcelUtil<CctMoneyWithdrawal>(CctMoneyWithdrawal.class);
        return util.exportExcel(list, "withdrawal");
    }

    /**
     * 新增提现记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存  提现
     *  添加提现记录
     *  1.前台必须穿入小数点后两位 比方 1.00 不能删除   2.必须四舍五入取后两位
     */
    @RequiresPermissions("system:withdrawal:add")
    @Log(title = "【提现记录】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctMoneyWithdrawal cctMoneyWithdrawal) {
        return cctMoneyWithdrawalService.insertCctMoneyWithdrawal(cctMoneyWithdrawal);
    }

    /**
     * 修改提现记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        CctMoneyWithdrawal cctMoneyWithdrawal = cctMoneyWithdrawalService.selectCctMoneyWithdrawalById(id);
        mmap.put("cctMoneyWithdrawal", cctMoneyWithdrawal);
        return prefix + "/edit";
    }

    /**
     * 修改保存提现记录
     */
    @RequiresPermissions("system:withdrawal:edit")
    @Log(title = "提现记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctMoneyWithdrawal cctMoneyWithdrawal) {
        return toAjax(cctMoneyWithdrawalService.updateCctMoneyWithdrawal(cctMoneyWithdrawal));
    }

    /**
     * 删除提现记录
     */
    @RequiresPermissions("system:withdrawal:remove")
    @Log(title = "提现记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cctMoneyWithdrawalService.deleteCctMoneyWithdrawalByIds(ids));
    }

    /**
     * 展示余额与费率
     * @param id 用户 id
     * @return
     */
    @GetMapping("MoneyAndRate/{id}")
    @ResponseBody
    public AjaxResult selectMoneyAndRate(@PathVariable("id") Integer id) {

        return AjaxResult.success(cctMoneyWithdrawalService.selectMoneyAndRate(id));
    }

    /**
     * 提现审核
     * @param cctMoneyWithdrawal 对象
     * @return
     */
    @PostMapping("WithdrawalAudit")
    @ResponseBody
    public AjaxResult WithdrawalAudit(CctMoneyWithdrawal cctMoneyWithdrawal){

        return toAjax(cctMoneyWithdrawalService.WithdrawalAudit(cctMoneyWithdrawal));
    }



}
