package com.ruoyi.app.service.wallet.impl;


import com.ruoyi.app.domain.me.CctMeMessage;
import com.ruoyi.app.domain.rate.CctRate;
import com.ruoyi.app.domain.wallet.CctMoneyWithdrawal;
import com.ruoyi.app.domain.wallet.CctUserMoney;
import com.ruoyi.app.mapper.rate.CctRateMapper;
import com.ruoyi.app.mapper.wallet.CctMoneyWithdrawalMapper;
import com.ruoyi.app.mapper.wallet.CctUserMoneyMapper;
import com.ruoyi.app.service.me.impl.CctMeMessageServiceImpl;
import com.ruoyi.app.service.wallet.ICctMoneyWithdrawalService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-25
 */
@Service
public class CctMoneyWithdrawalServiceImpl implements ICctMoneyWithdrawalService {
    @Autowired
    private CctMoneyWithdrawalMapper cctMoneyWithdrawalMapper;

    @Autowired
    private CctUserMoneyMapper userMoneyMapper;

    @Autowired
    private CctRateMapper rateMapper;
    @Autowired
    private CctMeMessageServiceImpl meMessageService;


    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public CctMoneyWithdrawal selectCctMoneyWithdrawalById(Integer id) {
        return cctMoneyWithdrawalMapper.selectCctMoneyWithdrawalById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param cctMoneyWithdrawal 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CctMoneyWithdrawal> selectCctMoneyWithdrawalList(CctMoneyWithdrawal cctMoneyWithdrawal) {
        return cctMoneyWithdrawalMapper.selectCctMoneyWithdrawalList(cctMoneyWithdrawal);
    }

    /**
     * 添加提现记录
     * 1.前台必须穿入小数点后两位 比方 1.00 不能删除   2.必须四舍五入取后两位
     *
     * @param cctMoneyWithdrawal 【请填写功能名称】
     * @return 结果
     */
    @Override
    public AjaxResult insertCctMoneyWithdrawal(CctMoneyWithdrawal cctMoneyWithdrawal) {
        AjaxResult ajaxResult = new AjaxResult();
        HashMap map = new HashMap();
//        查询费率
        CctRate rate = rateMapper.selectCctRateById(1);

//        手续费
        BigDecimal serviceCharge = cctMoneyWithdrawal.getMoney().subtract(cctMoneyWithdrawal.getMoney().multiply(rate.getRate().divide(new BigDecimal("100"))));

//        提现金额判断 是否正确   用户传进来的  到账金额  与  提现-手续费 的金额是否相同
        if (cctMoneyWithdrawal.getRealityMoney().compareTo(serviceCharge.setScale(2,BigDecimal.ROUND_HALF_UP))==0) {

            //        判断账户中是否有足够金额
            CctUserMoney cctUserMoney = userMoneyMapper.selectCctUserMoneyByUserId(cctMoneyWithdrawal.getUId());

            //        余额>=提现金额
            if (cctUserMoney.getMoney().compareTo(cctMoneyWithdrawal.getMoney()) > -1) {
                //暂时   我的余额减去提现金额
                cctUserMoney.setMoney(cctUserMoney.getMoney().subtract(cctMoneyWithdrawal.getMoney()));
                //修改我的金额
                userMoneyMapper.updateCctUserMoney(cctUserMoney);
                //添加提现记录
                cctMoneyWithdrawalMapper.insertCctMoneyWithdrawal(cctMoneyWithdrawal);
//              提现添加消息给个人
                CctMeMessage cctMeMessage = new CctMeMessage();
                cctMeMessage.setUserId(Long.valueOf(cctMoneyWithdrawal.getUId()));
                cctMeMessage.setTitle("提现正在审核");
                cctMeMessage.setContent("您的提现申请已经提交,请耐心等待消息.");
                cctMeMessage.setSendTime(DateUtils.getNowDate());
                meMessageService.insertCctMeMessage(cctMeMessage);
                return ajaxResult.success();
            } else return ajaxResult.error("余额不足");
        } else return ajaxResult.error("手续费可能有刷新,稍后再试");
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param cctMoneyWithdrawal 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCctMoneyWithdrawal(CctMoneyWithdrawal cctMoneyWithdrawal) {
        return cctMoneyWithdrawalMapper.updateCctMoneyWithdrawal(cctMoneyWithdrawal);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCctMoneyWithdrawalByIds(String ids) {
        return cctMoneyWithdrawalMapper.deleteCctMoneyWithdrawalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCctMoneyWithdrawalById(Integer id) {
        return cctMoneyWithdrawalMapper.deleteCctMoneyWithdrawalById(id);
    }

    /**
     * 提现界面展示余额与手续费率
     *
     * @param id 用户id
     * @return
     */
    @Override
    public Map selectMoneyAndRate(Integer id) {
//        查询费率
        CctRate rate = rateMapper.selectCctRateById(1);
//        查询余额
        CctUserMoney money = userMoneyMapper.selectCctUserMoneyByUserId(id);
//        存入map
        HashMap map = new HashMap();
        map.put("rate", rate.getRate());
        map.put("money", money.getMoney());
        return map;
    }

    /**
     * 提现审核
     *
     * @param cctMoneyWithdrawal 对象
     * @return
     */
    @Override
    public int WithdrawalAudit(CctMoneyWithdrawal cctMoneyWithdrawal) {
//         同意提现
        if (cctMoneyWithdrawal.getStatus() == 1) {
            //修改提现状态
            cctMoneyWithdrawalMapper.updateCctMoneyWithdrawal(cctMoneyWithdrawal);
//          同意提现添加消息给个人
            CctMeMessage cctMeMessage = new CctMeMessage();
            cctMeMessage.setUserId(Long.valueOf(cctMoneyWithdrawal.getUId()));
            cctMeMessage.setTitle("提现到账提醒");
            cctMeMessage.setContent("您的提现申请已经通过,请及时查看 将于本月15号提现到您指定的账户.");
            cctMeMessage.setSendTime(DateUtils.getNowDate());
            meMessageService.insertCctMeMessage(cctMeMessage);
        }
//        拒绝提现
        else if (cctMoneyWithdrawal.getStatus() == 2) {
            //拿到 提现对象
            CctMoneyWithdrawal moneyWithdrawal = cctMoneyWithdrawalMapper.selectCctMoneyWithdrawalById(cctMoneyWithdrawal.getId());
            //拿到我的钱包
            CctUserMoney cctUserMoney = userMoneyMapper.selectCctUserMoneyByUserId(moneyWithdrawal.getUId());
            //从我的钱包中加上提现金额   返还到我的余额   因为在提现提交的时候已经把余额扣除了
            cctUserMoney.setMoney(cctUserMoney.getMoney().add(moneyWithdrawal.getMoney()));
            //修改金额
            userMoneyMapper.updateCctUserMoney(cctUserMoney);
            //修改提现状态
            cctMoneyWithdrawalMapper.updateCctMoneyWithdrawal(cctMoneyWithdrawal);
//          拒绝提现添加消息给个人
            CctMeMessage cctMeMessage = new CctMeMessage();
            cctMeMessage.setUserId(Long.valueOf(cctMoneyWithdrawal.getUId()));
            cctMeMessage.setTitle("提现回绝提醒");
            cctMeMessage.setSendTime(DateUtils.getNowDate());
            cctMeMessage.setContent("您的提现申请不通过,如有问题请查看提现记录回绝原因,或者拨打电话.");
            meMessageService.insertCctMeMessage(cctMeMessage);
        }
        return 1;
    }
}
