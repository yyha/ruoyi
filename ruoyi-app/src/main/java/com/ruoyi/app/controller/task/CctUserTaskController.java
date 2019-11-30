package com.ruoyi.app.controller.task;

import java.util.List;

import com.ruoyi.app.domain.task.CctUserTask;
import com.ruoyi.app.service.task.ICctUserTaskService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
 * 领取任务Controller
 *
 * @author ruoyi
 * @date 2019-11-11
 */
@Controller
@RequestMapping("user/mytask")
@Api("领取任务Controller")
public class CctUserTaskController extends BaseController {
    private String prefix = "user";

    @Autowired
    private ICctUserTaskService cctUserTaskService;

    /**
     * 查询领取任务列表
     */
    @GetMapping("")
    public String userTask() {

        return "task/usertask";
    }


    /**
     * 查询领取任务列表
     */
    @PostMapping("/list")
    @ResponseBody
    @ApiOperation("查询领取任务列表")
    public TableDataInfo list(CctUserTask cctUserTask) {

        SysUser user = ShiroUtils.getSysUser();
        cctUserTask.setUserId(user.getUserId());
        startPage();
        List<CctUserTask> list = cctUserTaskService.selectCctUserTaskList(cctUserTask);
        return getDataTable(list);
    }

    /**
     * 导出领取任务列表
     */
    @RequiresPermissions("system:task:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctUserTask cctUserTask) {
        List<CctUserTask> list = cctUserTaskService.selectCctUserTaskList(cctUserTask);
        ExcelUtil<CctUserTask> util = new ExcelUtil<CctUserTask>(CctUserTask.class);
        return util.exportExcel(list, "task");
    }

    /**
     * 新增领取任务
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存领取任务
     */
    @Log(title = "领取任务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @ApiOperation("领取任务")
    @ApiImplicitParams(@ApiImplicitParam(name = "taskId", value = "领取任务id", dataType = "Long"))
    public AjaxResult addSave(CctUserTask cctUserTask) {
        return cctUserTaskService.insertCctUserTask(cctUserTask);
    }

    /**
     * 修改领取任务
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
        CctUserTask cctUserTask = cctUserTaskService.selectCctUserTaskById(userId);
        mmap.put("cctUserTask", cctUserTask);
        return prefix + "/edit";
    }

    /**
     * 任务发起延期/取消
     */
    @PostMapping("/edit")
    @ResponseBody
    @ApiOperation("延期/取消任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "领取任务id", dataType = "Long"),
            @ApiImplicitParam(name = "applyType", value = "申请状态(1:延期,2:取消)", dataType = "Integer"),
            @ApiImplicitParam(name = "cancelReason", value = "取消原因", dataType = "String"),
            @ApiImplicitParam(name = "delayReason", value = "延期原因", dataType = "String"),
            @ApiImplicitParam(name = "delayto", value = "延期至", dataType = "Date")})
    public AjaxResult editSave(@Validated CctUserTask cctUserTask,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return AjaxResult.error(errorMsg);
        }
        return toAjax(cctUserTaskService.updateCctUserTask(cctUserTask));
    }

    /**
     * 删除领取任务
     */
    @RequiresPermissions("system:task:remove")
    @Log(title = "领取任务", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cctUserTaskService.deleteCctUserTaskByIds(ids));
    }

    /**
     * 查询领取任务详情
     */
    @PostMapping("/details")
    @ResponseBody
    @ApiOperation("查询领取任务详情")
    @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "领取任务id", dataType = "Long"))
    public AjaxResult details(@Validated CctUserTask cctUserTask, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return AjaxResult.error(errorMsg);
        }
        return new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功", cctUserTaskService.selectCctUserTaskById(cctUserTask.getId()));
    }
}
