package org.example.novel.novel.service;

import org.example.novel.novel.domain.OrderPay;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.novel.novel.domain.vo.OrderPayVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【order_pay(充值订单)】的数据库操作Service
* @createDate 2024-11-22 16:14:17
*/
public interface OrderPayService extends IService<OrderPay> {
    List<OrderPayVo> list(Map map);

    Map<Object, Object> tableSta(Date minDate);
}
