package org.example.novelcommon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 充值订单
 * @TableName order_pay
 */
@TableName(value ="order_pay")
@Data
public class OrderPay implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商户订单号
     */
    private Long outTradeNo;

    /**
     * 支付宝/微信交易号
     */
    private String tradeNo;

    /**
     * 支付渠道，1：支付宝，2：微信
     */
    private Integer payChannel;

    /**
     * 交易金额(单位元)
     */
    private Integer totalAmount;

    /**
     * 支付用户ID
     */
    private Long userId;

    /**
     * 支付状态：0：支付失败，1：支付成功，2：待支付
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderPay other = (OrderPay) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", userId=").append(userId);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}