package org.example.novel.novel.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 新闻表
 * @TableName news
 */
@TableName(value ="news")
@Data
public class News implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 类别ID
     */
    private Integer catId;

    /**
     * 分类名
     */
    private String catName;

    /**
     * 来源
     */
    private String sourceName;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发布时间
     */
    private Date createTime;

    /**
     * 发布人ID
     */
    private Long createUserId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人ID
     */
    private Long updateUserId;

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
        News other = (News) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getCatName() == null ? other.getCatName() == null : this.getCatName().equals(other.getCatName()))
            && (this.getSourceName() == null ? other.getSourceName() == null : this.getSourceName().equals(other.getSourceName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCatId() == null) ? 0 : getCatId().hashCode());
        result = prime * result + ((getCatName() == null) ? 0 : getCatName().hashCode());
        result = prime * result + ((getSourceName() == null) ? 0 : getSourceName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", catId=").append(catId);
        sb.append(", catName=").append(catName);
        sb.append(", sourceName=").append(sourceName);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}