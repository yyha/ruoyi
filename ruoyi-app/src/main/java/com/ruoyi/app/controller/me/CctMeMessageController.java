package com.ruoyi.app.controller.me;

import com.ruoyi.app.domain.me.CctMeMessage;
import com.ruoyi.app.service.me.ICctMeMessageService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller
 * 个人中心-消息
 * @author ruoyi
 * @date 2019-11-20
 */
@Controller
@RequestMapping("/me/message")
@Api("个人消息中心")
public class CctMeMessageController extends BaseController
{
    private String prefix = "message";

    @Autowired
    private ICctMeMessageService cctMeMessageService;

    @RequiresPermissions("system:message:view")
    @GetMapping()
    public String message()
    {
        return prefix + "/message";
    }

    /**
     * 查询列表
     */
    @RequiresPermissions("system:message:list")
    @PostMapping("/list")
    @ApiOperation("个人消息中心查询列表")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户id", dataType = "Long")})
    public TableDataInfo list(CctMeMessage cctMeMessage)
    {

        startPage();
        List<CctMeMessage> list = cctMeMessageService.selectCctMeMessageList(cctMeMessage);
        return getDataTable(list);
    }

    /**
     * 查询单条
     */
    @RequiresPermissions("system:message:list")
    @PostMapping("/message")
    @ApiOperation("个人消息查询单条")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "消息id", dataType = "Long"),
                        @ApiImplicitParam(name = "userId", value = "用户id", dataType = "Long"),
                        @ApiImplicitParam(name = "source", value = "类别", dataType = "Long")
    })
    public AjaxResult MeMessage(CctMeMessage cctMeMessage)
    {
        return AjaxResult.success(cctMeMessageService.determineTheCategorySingleQuery(cctMeMessage));
    }

    /**
     * 导出列表
     */
    @RequiresPermissions("system:message:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctMeMessage cctMeMessage)
    {
        List<CctMeMessage> list = cctMeMessageService.selectCctMeMessageList(cctMeMessage);
        ExcelUtil<CctMeMessage> util = new ExcelUtil<CctMeMessage>(CctMeMessage.class);
        return util.exportExcel(list, "message");
    }

    /**
     * 新增
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存
     */
    @RequiresPermissions("system:message:add")
    @Log(title = "", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctMeMessage cctMeMessage)
    {
        return toAjax(cctMeMessageService.insertCctMeMessage(cctMeMessage));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CctMeMessage cctMeMessage = cctMeMessageService.selectCctMeMessageById(id);
        mmap.put("cctMeMessage", cctMeMessage);
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    @RequiresPermissions("system:message:edit")
    @Log(title = "", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctMeMessage cctMeMessage)
    {
        return toAjax(cctMeMessageService.updateCctMeMessage(cctMeMessage));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:message:remove")
    @Log(title = "", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cctMeMessageService.deleteCctMeMessageByIds(ids));
    }

    /**
     * 删除  公告和个人
     */
    @RequiresPermissions("system:message:remove")
    @Log(title = "", businessType = BusinessType.DELETE)
    @PostMapping( "/delete")
    @ApiOperation("删除  公告和个人消息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户id", dataType = "Long")})
    @ResponseBody
    public AjaxResult delete(Long id)
    {
        return toAjax(cctMeMessageService.deleteCctMeMessageUserId(id));
    }




}
