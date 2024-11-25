package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.OrderPay;
import org.example.novelcommon.mapper.OrderPayMapper;
import org.example.novelcommon.service.OrderPayService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【order_pay(充值订单)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class OrderPayServiceImpl extends ServiceImpl<OrderPayMapper, OrderPay>
    implements OrderPayService{

}




