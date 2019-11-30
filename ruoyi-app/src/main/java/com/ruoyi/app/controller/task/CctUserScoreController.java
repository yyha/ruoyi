package com.ruoyi.app.controller.task;

import java.util.List;

import com.ruoyi.app.domain.task.CctUserScore;
import com.ruoyi.app.service.task.ICctUserScoreService;
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
 * 用户信用分数Controller
 *
 * @author ruoyi
 * @date 2019-11-11
 */
@Controller
@RequestMapping("/score")
public class CctUserScoreController extends BaseController {
    private String prefix = "score";

    @Autowired
    private ICctUserScoreService cctUserScoreService;

    @RequiresPermissions("system:score:view")
    @GetMapping()
    public String score() {
        return prefix + "/score";
    }

    /**
     * 查询用户信用分数列表
     */
    @RequiresPermissions("system:score:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctUserScore cctUserScore) {
        startPage();
        List<CctUserScore> list = cctUserScoreService.selectCctUserScoreList(cctUserScore);
        return getDataTable(list);
    }

    /**
     * 导出用户信用分数列表
     */
    @RequiresPermissions("system:score:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctUserScore cctUserScore) {
        List<CctUserScore> list = cctUserScoreService.selectCctUserScoreList(cctUserScore);
        ExcelUtil<CctUserScore> util = new ExcelUtil<CctUserScore>(CctUserScore.class);
        return util.exportExcel(list, "score");
    }

    /**
     * 新增用户信用分数
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户信用分数
     */
    @RequiresPermissions("system:score:add")
    @Log(title = "用户信用分数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctUserScore cctUserScore) {
        return toAjax(cctUserScoreService.insertCctUserScore(cctUserScore));
    }

    /**
     * 修改用户信用分数
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        CctUserScore cctUserScore = cctUserScoreService.selectCctUserScoreById(id);
        mmap.put("cctUserScore", cctUserScore);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户信用分数
     */
    @RequiresPermissions("system:score:edit")
    @Log(title = "用户信用分数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctUserScore cctUserScore) {
        return toAjax(cctUserScoreService.updateCctUserScore(cctUserScore));
    }

    /**
     * 删除用户信用分数
     */
    @RequiresPermissions("system:score:remove")
    @Log(title = "用户信用分数", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cctUserScoreService.deleteCctUserScoreByIds(ids));
    }
}
