package com.ruoyi.app.controller.task;

import java.util.List;

import com.ruoyi.app.domain.task.CctTask;
import com.ruoyi.app.service.task.ICctTaskService;
import com.ruoyi.common.utils.StringUtils;
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
 * 任务Controller
 *
 * @author ruoyi
 * @date 2019-11-11
 */
@Controller
@RequestMapping("/task")
public class CctTaskController extends BaseController {
    private String prefix = "task";

    @Autowired
    private ICctTaskService cctTaskService;

    @RequiresPermissions("system:task:view")
    @GetMapping()
    public String task() {
        return prefix + "/task";
    }

    /**
     * 查询任务列表
     */
    @RequiresPermissions("system:task:list")
    @ApiOperation("查询任务列表")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctTask cctTask) {
        startPage();
        List<CctTask> list = cctTaskService.selectCctTaskList(cctTask);
        return getDataTable(list);
    }

    /**
     * 导出任务列表
     */
    @RequiresPermissions("system:task:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctTask cctTask) {
        List<CctTask> list = cctTaskService.selectCctTaskList(cctTask);
        ExcelUtil<CctTask> util = new ExcelUtil<CctTask>(CctTask.class);
        return util.exportExcel(list, "task");
    }

    /**
     * 新增任务
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存任务
     */
    @RequiresPermissions("system:task:add")
    @Log(title = "任务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctTask cctTask) {
        return toAjax(cctTaskService.insertCctTask(cctTask));
    }

    /**
     * 修改任务
     */
    @GetMapping("/edit/{tId}")
    public String edit(@PathVariable("tId") String tId, ModelMap mmap) {
        CctTask cctTask = cctTaskService.selectCctTaskById(tId);
        String image = cctTask.getImage();
        if (StringUtils.isNotBlank(image)){
            String[] images = image.split(",");
            cctTask.setImages(images);
            cctTask.setImage(images[0]);
        }
        mmap.put("cctTask", cctTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存任务
     */
    @RequiresPermissions("system:task:edit")
    @Log(title = "任务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctTask cctTask) {
        return toAjax(cctTaskService.updateCctTask(cctTask));
    }

    /**
     * 删除任务
     */
    @RequiresPermissions("system:task:remove")
    @Log(title = "任务", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cctTaskService.deleteCctTaskByIds(ids));
    }


    /**
     * 查询任务详情
     */
    @PostMapping("/details")
    @ResponseBody
    @ApiOperation("查询任务详情")
    @ApiImplicitParams(@ApiImplicitParam(name = "tId", value = "任务id", dataType = "String"))
    public AjaxResult details(String tId) {
        CctTask cctTask = cctTaskService.selectCctTaskById(tId);
        return new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功", cctTask);
    }
}
