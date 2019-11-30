package com.ruoyi.app.controller.village;

import java.util.List;

import com.ruoyi.app.domain.village.CctVillageMaintain;
import com.ruoyi.app.service.village.ICctVillageMaintainService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

/**
 * 村维修Controller
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Controller
@RequestMapping("/village/maintain")
public class CctVillageMaintainController extends BaseController
{
    private String prefix = "maintain";

    @Autowired
    private ICctVillageMaintainService cctVillageMaintainService;

    @RequiresPermissions("system:maintain:view")
    @GetMapping()
    public String maintain()
    {
        return prefix + "/maintain";
    }

    @RequiresPermissions("system:maintain:view")
    @GetMapping("/my")
    public String mymaintain()
    {
        return prefix + "/mymaintain";
    }

    /**
     * 查询村维修列表
     */
    @PostMapping("/list")
    @ResponseBody
    @ApiOperation("我申请的村维修记录")
    @ApiImplicitParam(name = "uId",value = "用户id",paramType = "Long",required = false)
    public TableDataInfo list(CctVillageMaintain cctVillageMaintain)
    {
        startPage();
        List<CctVillageMaintain> list = cctVillageMaintainService.selectCctVillageMaintainList(cctVillageMaintain);
        return getDataTable(list);
    }

    /**
     * 导出村维修列表
     */
    @RequiresPermissions("system:maintain:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctVillageMaintain cctVillageMaintain)
    {
        List<CctVillageMaintain> list = cctVillageMaintainService.selectCctVillageMaintainList(cctVillageMaintain);
        ExcelUtil<CctVillageMaintain> util = new ExcelUtil<CctVillageMaintain>(CctVillageMaintain.class);
        return util.exportExcel(list, "maintain");
    }

    /**
     * 新增村维修
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存村维修
     */
    @PostMapping("/add")
    @ResponseBody
    @ApiOperation("添加村维修")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address",value = "家庭住址",paramType = "String"),
            @ApiImplicitParam(name = "description",value = "问题描述",paramType = "String"),
            @ApiImplicitParam(name = "contactMobile",value = "联系电话",paramType = "String"),
    })
    public AjaxResult addSave(CctVillageMaintain cctVillageMaintain)
    {
        return toAjax(cctVillageMaintainService.insertCctVillageMaintain(cctVillageMaintain));
    }

    /**
     * 修改村维修
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CctVillageMaintain cctVillageMaintain = cctVillageMaintainService.selectCctVillageMaintainById(id);
        mmap.put("cctVillageMaintain", cctVillageMaintain);
        return prefix + "/allot";
    }

    /**
     * 修改保存村维修
     */
    @PostMapping("/edit")
    @ResponseBody
    @ApiOperation("修改村维修")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "维修id",paramType = "Long"),
            @ApiImplicitParam(name = "address",value = "家庭住址",paramType = "String"),
            @ApiImplicitParam(name = "description",value = "问题描述",paramType = "String"),
            @ApiImplicitParam(name = "contactMobile",value = "联系电话",paramType = "String"),
            @ApiImplicitParam(name = "status",value = "维修状态",paramType = "Integer"),
    })
    public AjaxResult editSave(CctVillageMaintain cctVillageMaintain)
    {
        return toAjax(cctVillageMaintainService.updateCctVillageMaintain(cctVillageMaintain));
    }

    /**
     * 删除村维修
     */
    @Log(title = "村维修", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    @ApiOperation("删除村维修记录")
    @ApiImplicitParam(name = "ids",value = "维修id",paramType = "Long")
    public AjaxResult remove(String ids)
    {
        return toAjax(cctVillageMaintainService.deleteCctVillageMaintainByIds(ids));
    }
}
