package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.OrderPay;
import org.example.novel.novel.domain.vo.OrderPayVo;
import org.example.novel.novel.mapper.UserMapper;
import org.example.novel.novel.service.OrderPayService;
import org.example.novel.novel.mapper.OrderPayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
* @author 15268
* @description 针对表【order_pay(充值订单)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class OrderPayServiceImpl extends ServiceImpl<OrderPayMapper, OrderPay>
    implements OrderPayService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderPayMapper orderPayMapper;

    @Override
    public List<OrderPayVo> list(Map map) {
        List<OrderPay> list = orderPayMapper.list(map);
        List<OrderPayVo> listVo=new ArrayList<>();
        list.stream().forEach(orderPay -> {
            OrderPayVo payVo=new OrderPayVo();
            payVo.setOutTradeNo(orderPay.getOutTradeNo());
            payVo.setPayChannel(orderPay.getPayChannel());
            payVo.setPayStatus(orderPay.getPayStatus());
            payVo.setCreateTime(orderPay.getCreateTime());
            payVo.setTotalAmount(orderPay.getTotalAmount());
            payVo.setUpdateTime(orderPay.getUpdateTime());
            payVo.setUserId(orderPay.getUserId());
            payVo.setId(orderPay.getId());
            payVo.setTradeNo(orderPay.getTradeNo());
            payVo.setUserName(userMapper.getUserNameById(orderPay.getUserId()));
            listVo.add(payVo);
        });
        return listVo;
    }

    @Override
    public Map<Object, Object> tableSta(Date minDate) {
        List<Map<Object,Object>> count=orderPayMapper.count(minDate);
    }
}




