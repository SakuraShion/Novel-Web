package org.example.novel.novel.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.example.novel.novel.domain.OrderPay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【order_pay(充值订单)】的数据库操作Mapper
* @createDate 2024-11-22 16:14:17
* @Entity mp.domain.OrderPay
*/
public interface OrderPayMapper extends BaseMapper<OrderPay> {
    List<OrderPay> list (Map map);

    @MapKey("staDay")
    List<Map<Object, Object>> count(Date minDate);
}




