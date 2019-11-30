package com.ruoyi.app.controller.notice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.service.ISysNoticeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告、通知
 *
 * @author wlg
 * @version V1.0
 * @Package com.ruoyi.app.controller.notice
 * @date 2019/11/15 0015 13:59
 * @Copyright © 2019-2020 河南讯众科技有限公司
 */

@Controller
@RequestMapping("/notice")
public class CctNoticeController extends BaseController {

    @Autowired
    private ISysNoticeService noticeService;

    /**
     * 查询公告/村内事列表接口
     */
    @PostMapping("/list/{noticeType}/{status}")
    @ApiOperation(value = "查询村部通知/村内事列表", notes = "noticeType必填，1村内事 2村部通知、status必填，固定为0")
    @ApiImplicitParam(name = "status", value = "0", required = true)
    @ResponseBody
    public TableDataInfo appList(
            @PathVariable(value = "noticeType",required = true) String noticeType,
            @PathVariable(value = "status", required = true) String status) {
        SysNotice notice = new SysNotice();
        notice.setNoticeType(noticeType);
        notice.setStatus(status);
        startPage();
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 查看村部通知/村内事详情接口
     */
    @GetMapping("/get/{noticeId}")
    @ApiOperation(value = "查看村部通知/村内事详情", notes = "noticeId必填")
    @ApiImplicitParam(name = "noticeId", required = true)
    @ResponseBody
    public String get(
            @PathVariable(value = "noticeId",required = true) Long noticeId) {
        SysNotice notice = noticeService.selectNoticeById(noticeId);
        ObjectMapper mapper = new ObjectMapper();
        String noticeJson = null;
        try {
            noticeJson = mapper.writeValueAsString(notice);
        } catch (JsonProcessingException e) {
            throw new BusinessException("json转换异常，请联系管理员");
        }
        return noticeJson;
    }
}
