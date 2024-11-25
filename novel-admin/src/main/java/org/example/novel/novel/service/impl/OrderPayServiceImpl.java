package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.OrderPay;
import org.example.novel.novel.service.OrderPayService;
import org.example.novel.novel.mapper.OrderPayMapper;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【order_pay(充值订单)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class OrderPayServiceImpl extends ServiceImpl<OrderPayMapper, OrderPay>
    implements OrderPayService{

}




