package org.example.novel.novel.domain.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.novel.common.jsonserializer.LongToStringSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author：hb
 * @Package：org.example.novel.novel.domain.vo
 * @Project：my
 * @Date：25/11/2024 3:57 pm
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderPayVo {
    private static final long serialVersionUID = 1L;


    //主键
    //java中的long能表示的范围比js中number大,也就意味着部分数值在js中存不下(变成不准确的值)
    //所以通过序列化成字符串来解决
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long id;
    //保留
    //java中的long能表示的范围比js中number大,也就意味着部分数值在js中存不下(变成不准确的值)
    //所以通过序列化成字符串来解决
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long outTradeNo;
    //订单号
    private String tradeNo;
    //保留
    private Integer payChannel;
    //交易香蕉币
    private Integer totalAmount;
    //支付用户ID
    //java中的long能表示的范围比js中number大,也就意味着部分数值在js中存不下(变成不准确的值)
    //所以通过序列化成字符串来解决
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long userId;
    //支付状态：0：支付失败，1：支付成功，2：待支付
    private Integer payStatus;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String userName;
}
