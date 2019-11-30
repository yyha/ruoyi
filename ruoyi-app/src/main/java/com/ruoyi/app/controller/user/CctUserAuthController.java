package com.ruoyi.app.controller.user;

import com.ruoyi.app.domain.user.CctUserAuth;
import com.ruoyi.app.service.user.ICctUserAuthService;
import com.ruoyi.app.service.wallet.ICctUserMoneyService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
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
 * 用户实名认证Controller
 *
 * @author ruoyi
 * @date 2019-11-11
 */
@Controller
@RequestMapping("/user/auth")
public class CctUserAuthController extends BaseController {
    private String prefix = "system/auth";

    @Autowired
    private ICctUserAuthService cctUserAuthService;

    @Autowired
    private ICctUserMoneyService moneyService;

    @RequiresPermissions("system:auth:view")
    @GetMapping()
    public String auth() {
        return prefix + "/auth";
    }

    /**
     * 查询用户实名认证列表
     */
    @RequiresPermissions("system:auth:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CctUserAuth cctUserAuth) {
        startPage();
        List<CctUserAuth> list = cctUserAuthService.selectCctUserAuthList(cctUserAuth);
        return getDataTable(list);
    }

    /**
     * 导出用户实名认证列表
     */
    @RequiresPermissions("system:auth:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CctUserAuth cctUserAuth) {
        List<CctUserAuth> list = cctUserAuthService.selectCctUserAuthList(cctUserAuth);
        ExcelUtil<CctUserAuth> util = new ExcelUtil<CctUserAuth>(CctUserAuth.class);
        return util.exportExcel(list, "auth");
    }

    /**
     * 新增用户实名认证
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户实名认证
     */
    @ApiOperation("新增保存用户实名认证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vId", value = "绑定村id", paramType = "Long"),
            @ApiImplicitParam(name = "realName", value = "真实姓名", paramType = "String"),
            @ApiImplicitParam(name = "cardId", value = "身份证编号", paramType = "Long"),
            @ApiImplicitParam(name = "cardFront", value = "身份证正面", paramType = "String"),
            @ApiImplicitParam(name = "cardRear", value = "身份证反面", paramType = "String"),
            @ApiImplicitParam(name = "cardHand", value = "身份证手持", paramType = "String")
    })
    @Log(title = "用户实名认证", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CctUserAuth cctUserAuth) {
//        创建对象我的钱包对象,添加我的余额
        moneyService.insertCctUserMoney(cctUserAuth.getUId().intValue());
        return toAjax(cctUserAuthService.insertCctUserAuth(cctUserAuth));
    }

    /**
     * 修改用户实名认证
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        CctUserAuth cctUserAuth = cctUserAuthService.selectCctUserAuthById(id);
        mmap.put("cctUserAuth", cctUserAuth);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户实名认证
     */
    @RequiresPermissions("system:auth:edit")
    @Log(title = "用户实名认证", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CctUserAuth cctUserAuth) {
        return toAjax(cctUserAuthService.updateCctUserAuth(cctUserAuth));
    }

    /**
     * 删除用户实名认证
     */
    @RequiresPermissions("system:auth:remove")
    @Log(title = "用户实名认证", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cctUserAuthService.deleteCctUserAuthByIds(ids));
    }
}
