package com.ruoyi.app.controller.village;

import java.util.List;

import com.ruoyi.app.domain.village.CctMaintainRecord;
import com.ruoyi.app.domain.village.CctVillageMaintain;
import com.ruoyi.app.service.village.ICctMaintainRecordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import io.swagger.annotations.Api;
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
 * 维修记录Controller
 * 
 * @author ruoyi
 * @date 2019-11-11
 */
@Controller
@RequestMapping("/village/record")
public class CctMaintainRecordController extends BaseController
{
    private String prefix = "record";

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ICctMaintainRecordService cctMaintainRecordService;

    @RequiresPermissions("system:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询维修工
     * @return
     */
    @PostMapping("/user")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        SysUser user = ShiroUtils.getSysUser();
        List<SysUser> list = userService.selectMaintainUsre(user);
        return getDataTable(list);
    }

    /**
     * 查询维修记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctMaintainRecord cctMaintainRecord)
    {
        SysUser user = ShiroUtils.getSysUser();
        cctMaintainRecord.setUId(user.getUserId());
        startPage();
        List<CctVillageMaintain> list = cctMaintainRecordService.selectCctMaintainRecordList(cctMaintainRecord);
        return getDataTable(list);
    }

//    /**
//     * 导出维修记录列表
//     */
//    @RequiresPermissions("system:record:export")
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(CctMaintainRecord cctMaintainRecord)
//    {
//        List<CctVillageMaintain> list = cctMaintainRecordService.selectCctMaintainRecordList(cctMaintainRecord);
//        ExcelUtil<CctMaintainRecord> util = new ExcelUtil<CctMaintainRecord>(CctMaintainRecord.class);
//        return util.exportExcel(list, "record");
//    }

    /**
     * 新增维修记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存维修记录
     */
    @PostMapping("/add")
    @ResponseBody
    @ApiOperation("新增保存维修记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mId",value = "维修id",paramType = "Long"),
            @ApiImplicitParam(name = "uId",value = "用户id",paramType = "Long"),
    })
    public AjaxResult addSave(CctMaintainRecord cctMaintainRecord)
    {
        return toAjax(cctMaintainRecordService.insertCctMaintainRecord(cctMaintainRecord));
    }

    /**
     * 修改维修记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CctMaintainRecord cctMaintainRecord = cctMaintainRecordService.selectCctMaintainRecordById(id);
        mmap.put("cctMaintainRecord", cctMaintainRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存维修记录
     */
    @RequiresPermissions("system:record:edit")
    @Log(title = "维修记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctMaintainRecord cctMaintainRecord)
    {
        return toAjax(cctMaintainRecordService.updateCctMaintainRecord(cctMaintainRecord));
    }

    /**
     * 删除维修记录
     */
    @RequiresPermissions("system:record:remove")
    @Log(title = "维修记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cctMaintainRecordService.deleteCctMaintainRecordByIds(ids));
    }
}
