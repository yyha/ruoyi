package com.ruoyi.web.controller.system;

import com.ruoyi.app.domain.task.CctUserScore;
import com.ruoyi.app.domain.task.CctUserTask;
import com.ruoyi.app.service.task.ICctUserScoreService;
import com.ruoyi.app.service.task.ICctUserTaskService;
import com.ruoyi.app.service.wallet.ICctMoneyIncomeService;
import com.ruoyi.app.service.wallet.ICctUserMoneyService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 延期申请 信息操作处理
 *
 * @author wlg
 */
@Controller
@RequestMapping("/system/task")
public class SysTaskAuditController extends BaseController {
    private String prefix = "system/task";

    @Autowired
    private ICctUserTaskService userTaskService;
    @Autowired
    private ICctUserScoreService cctUserScoreService;
    @Autowired
    private ICctMoneyIncomeService moneyIncomeService;
    @Autowired
    private ICctUserMoneyService userMoneyService;
    /**
     * 延期审核入口
     *
     * @return
     */
    @RequiresPermissions("system:delay:audit")
    @GetMapping("/delayaudit")
    public String delay() {
        return prefix + "/delay";
    }

    /**
     * 任务取消审核入口
     *
     * @return
     */
    @RequiresPermissions("system:task:cancel")
    @GetMapping("/cancel")
    public String cancel() {
        return prefix + "/cancel";
    }

    /**
     * 物料配送入口
     *
     * @return
     */
    @RequiresPermissions("system:task:distribution")
    @GetMapping("/distribution")
    public String distribution() {
        return prefix + "/distribution";
    }

    /**
     * 成品验收入口
     *
     * @return
     */
    @RequiresPermissions("system:task:producttake")
    @GetMapping("/producttake")
    public String producttake() {
        return prefix + "/producttake";
    }

    /**
     * 成品收取入口
     *
     * @return
     */
    @RequiresPermissions("system:task:collection")
    @GetMapping("/collection")
    public String collection() {
        return prefix + "/collection";
    }

    /**
     * 查询任务领取，延期申请,成品验收，成品收取，任务取消申请列表
     */
    @RequiresPermissions({"system:delay:audit", "system:task:distribution", "system:task:producttake", "system:task:collection", "system:task:cancel"})
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctUserTask userTask) {
        startPage();
        List<CctUserTask> list = userTaskService.selectDelayTaskList(userTask);
        return getDataTable(list);
    }


    /**
     * 审核延期申请、取消申请、物料配送、成品验收、成品收取
     */
    @RequiresPermissions({"system:delay:audit", "system:task:distribution", "system:task:producttake", "system:task:collection", "system:task:cancel"})
    @Log(title = "任务管理", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(CctUserTask userTask) {
        return toAjax(userTaskService.changeStatus(userTask));
    }


    /**
     * 修改用户信用分数
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        CctUserScore cctUserScore = cctUserScoreService.selectCctUserScoreById(id);
        mmap.put("cctUserScore", cctUserScore);
        return prefix + "/editscore";
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
}
