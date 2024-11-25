package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.OrderPay;
import org.example.novel.novel.domain.vo.OrderPayVo;
import org.example.novel.novel.service.OrderPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.novel.controller
 * @Project：my
 * @Date：25/11/2024 2:53 pm
 */
@RestController
@RequestMapping("/novel/pay")
public class PayController {

    @Autowired
    private OrderPayService payService;

    @ApiOperation(value = "获取充值订单列表", notes = "获取充值订单列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<OrderPayVo> payList = payService.list(params);
        int total =payList.size();
        PageBean pageBean = new PageBean(payList, total);
        return R.ok().put("data", pageBean);
    }



    @ApiOperation(value = "查看充值订单页面", notes = "查看充值订单页面")
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        OrderPay pay = payService.getById(id);
        return R.ok().put("pay", pay);

    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增充值订单", notes = "新增充值订单")
    @ResponseBody
    @PostMapping("/save")
    public R save(@RequestBody OrderPay pay) {
        if (payService.save(pay)) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改充值订单", notes = "修改充值订单")
    @ResponseBody
    @RequestMapping("/update")
    public R update(@RequestBody OrderPay pay) {
        payService.updateById(pay);
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除充值订单", notes = "删除充值订单")
    @PostMapping("/remove")
    @ResponseBody
    public R remove( Long id) {
        if (payService.removeById(id)) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除充值订单", notes = "批量删除充值订单")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        payService.removeBatchByIds(list);
        return R.ok();
    }
}
