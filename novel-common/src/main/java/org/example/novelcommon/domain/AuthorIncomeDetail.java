package org.example.novelcommon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 稿费收入明细统计表
 * @TableName author_income_detail
 */
@TableName(value ="author_income_detail")
@Data
public class AuthorIncomeDetail implements Serializable {
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
     * 作品ID,0表示全部作品
     */
    private Long bookId;

    /**
     * 收入日期
     */
    private Date incomeDate;

    /**
     * 订阅总额
     */
    private Integer incomeAccount;

    /**
     * 订阅次数
     */
    private Integer incomeCount;

    /**
     * 订阅人数
     */
    private Integer incomeNumber;

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
        AuthorIncomeDetail other = (AuthorIncomeDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getIncomeDate() == null ? other.getIncomeDate() == null : this.getIncomeDate().equals(other.getIncomeDate()))
            && (this.getIncomeAccount() == null ? other.getIncomeAccount() == null : this.getIncomeAccount().equals(other.getIncomeAccount()))
            && (this.getIncomeCount() == null ? other.getIncomeCount() == null : this.getIncomeCount().equals(other.getIncomeCount()))
            && (this.getIncomeNumber() == null ? other.getIncomeNumber() == null : this.getIncomeNumber().equals(other.getIncomeNumber()))
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
        result = prime * result + ((getIncomeDate() == null) ? 0 : getIncomeDate().hashCode());
        result = prime * result + ((getIncomeAccount() == null) ? 0 : getIncomeAccount().hashCode());
        result = prime * result + ((getIncomeCount() == null) ? 0 : getIncomeCount().hashCode());
        result = prime * result + ((getIncomeNumber() == null) ? 0 : getIncomeNumber().hashCode());
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
        sb.append(", incomeDate=").append(incomeDate);
        sb.append(", incomeAccount=").append(incomeAccount);
        sb.append(", incomeCount=").append(incomeCount);
        sb.append(", incomeNumber=").append(incomeNumber);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}