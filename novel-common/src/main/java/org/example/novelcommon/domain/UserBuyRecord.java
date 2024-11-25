package org.example.novelcommon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户消费记录表
 * @TableName user_buy_record
 */
@TableName(value ="user_buy_record")
@Data
public class UserBuyRecord implements Serializable {
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
     * 购买的小说ID
     */
    private Long bookId;

    /**
     * 购买的小说名
     */
    private String bookName;

    /**
     * 购买的章节ID
     */
    private Long bookIndexId;

    /**
     * 购买的章节名
     */
    private String bookIndexName;

    /**
     * 购买使用的屋币数量
     */
    private Integer buyAmount;

    /**
     * 购买时间
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
        UserBuyRecord other = (UserBuyRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getBookName() == null ? other.getBookName() == null : this.getBookName().equals(other.getBookName()))
            && (this.getBookIndexId() == null ? other.getBookIndexId() == null : this.getBookIndexId().equals(other.getBookIndexId()))
            && (this.getBookIndexName() == null ? other.getBookIndexName() == null : this.getBookIndexName().equals(other.getBookIndexName()))
            && (this.getBuyAmount() == null ? other.getBuyAmount() == null : this.getBuyAmount().equals(other.getBuyAmount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getBookName() == null) ? 0 : getBookName().hashCode());
        result = prime * result + ((getBookIndexId() == null) ? 0 : getBookIndexId().hashCode());
        result = prime * result + ((getBookIndexName() == null) ? 0 : getBookIndexName().hashCode());
        result = prime * result + ((getBuyAmount() == null) ? 0 : getBuyAmount().hashCode());
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
        sb.append(", bookId=").append(bookId);
        sb.append(", bookName=").append(bookName);
        sb.append(", bookIndexId=").append(bookIndexId);
        sb.append(", bookIndexName=").append(bookIndexName);
        sb.append(", buyAmount=").append(buyAmount);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}