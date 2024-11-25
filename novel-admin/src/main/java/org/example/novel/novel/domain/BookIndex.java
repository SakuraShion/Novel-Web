package org.example.novel.novel.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 小说目录表
 * @TableName book_index
 */
@TableName(value ="book_index")
@Data
public class BookIndex implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 小说ID
     */
    private Long bookId;

    /**
     * 目录号
     */
    private Integer indexNum;

    /**
     * 目录名
     */
    private String indexName;

    /**
     * 字数
     */
    private Integer wordCount;

    /**
     * 是否收费，1：收费，0：免费
     */
    private Integer isVip;

    /**
     * 章节费用（屋币）
     */
    private Integer bookPrice;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
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
        BookIndex other = (BookIndex) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getIndexNum() == null ? other.getIndexNum() == null : this.getIndexNum().equals(other.getIndexNum()))
            && (this.getIndexName() == null ? other.getIndexName() == null : this.getIndexName().equals(other.getIndexName()))
            && (this.getWordCount() == null ? other.getWordCount() == null : this.getWordCount().equals(other.getWordCount()))
            && (this.getIsVip() == null ? other.getIsVip() == null : this.getIsVip().equals(other.getIsVip()))
            && (this.getBookPrice() == null ? other.getBookPrice() == null : this.getBookPrice().equals(other.getBookPrice()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getIndexNum() == null) ? 0 : getIndexNum().hashCode());
        result = prime * result + ((getIndexName() == null) ? 0 : getIndexName().hashCode());
        result = prime * result + ((getWordCount() == null) ? 0 : getWordCount().hashCode());
        result = prime * result + ((getIsVip() == null) ? 0 : getIsVip().hashCode());
        result = prime * result + ((getBookPrice() == null) ? 0 : getBookPrice().hashCode());
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
        sb.append(", bookId=").append(bookId);
        sb.append(", indexNum=").append(indexNum);
        sb.append(", indexName=").append(indexName);
        sb.append(", wordCount=").append(wordCount);
        sb.append(", isVip=").append(isVip);
        sb.append(", bookPrice=").append(bookPrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}