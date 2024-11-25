package org.example.novelcommon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 稿费收入统计表
 * @TableName author_income
 */
@TableName(value ="author_income")
@Data
public class AuthorIncome implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 作家ID
     */
    private Long authorId;

    /**
     * 作品ID
     */
    private Long bookId;

    /**
     * 收入月份
     */
    private Date incomeMonth;

    /**
     * 税前收入（分）
     */
    private Long preTaxIncome;

    /**
     * 税后收入（分）
     */
    private Long afterTaxIncome;

    /**
     * 支付状态，0：待支付，1：已支付
     */
    private Integer payStatus;

    /**
     * 稿费确认状态，0：待确认，1：已确认
     */
    private Integer confirmStatus;

    /**
     * 详情
     */
    private String detail;

    /**
     * 
     */
    private Date createTime;

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
        AuthorIncome other = (AuthorIncome) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getIncomeMonth() == null ? other.getIncomeMonth() == null : this.getIncomeMonth().equals(other.getIncomeMonth()))
            && (this.getPreTaxIncome() == null ? other.getPreTaxIncome() == null : this.getPreTaxIncome().equals(other.getPreTaxIncome()))
            && (this.getAfterTaxIncome() == null ? other.getAfterTaxIncome() == null : this.getAfterTaxIncome().equals(other.getAfterTaxIncome()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getConfirmStatus() == null ? other.getConfirmStatus() == null : this.getConfirmStatus().equals(other.getConfirmStatus()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAuthorId() == null) ? 0 : getAuthorId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getIncomeMonth() == null) ? 0 : getIncomeMonth().hashCode());
        result = prime * result + ((getPreTaxIncome() == null) ? 0 : getPreTaxIncome().hashCode());
        result = prime * result + ((getAfterTaxIncome() == null) ? 0 : getAfterTaxIncome().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getConfirmStatus() == null) ? 0 : getConfirmStatus().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", authorId=").append(authorId);
        sb.append(", bookId=").append(bookId);
        sb.append(", incomeMonth=").append(incomeMonth);
        sb.append(", preTaxIncome=").append(preTaxIncome);
        sb.append(", afterTaxIncome=").append(afterTaxIncome);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", detail=").append(detail);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}