package org.example.novelcommon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 小说评论表
 * @TableName book_comment
 */
@TableName(value ="book_comment")
@Data
public class BookComment implements Serializable {
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
     * 评价内容
     */
    private String commentContent;

    /**
     * 回复数量
     */
    private Integer replyCount;

    /**
     * 审核状态，0：待审核，1：审核通过，2：审核不通过
     */
    private Integer auditStatus;

    /**
     * 评价时间
     */
    private Date createTime;

    /**
     * 评价人
     */
    private Long createUserId;

    /**
     * 支持数量
     */
    private Integer supportCount;

    /**
     * 反对数量
     */
    private Integer oppositionCount;

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
        BookComment other = (BookComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getCommentContent() == null ? other.getCommentContent() == null : this.getCommentContent().equals(other.getCommentContent()))
            && (this.getReplyCount() == null ? other.getReplyCount() == null : this.getReplyCount().equals(other.getReplyCount()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getSupportCount() == null ? other.getSupportCount() == null : this.getSupportCount().equals(other.getSupportCount()))
            && (this.getOppositionCount() == null ? other.getOppositionCount() == null : this.getOppositionCount().equals(other.getOppositionCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getCommentContent() == null) ? 0 : getCommentContent().hashCode());
        result = prime * result + ((getReplyCount() == null) ? 0 : getReplyCount().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getSupportCount() == null) ? 0 : getSupportCount().hashCode());
        result = prime * result + ((getOppositionCount() == null) ? 0 : getOppositionCount().hashCode());
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
        sb.append(", commentContent=").append(commentContent);
        sb.append(", replyCount=").append(replyCount);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", supportCount=").append(supportCount);
        sb.append(", oppositionCount=").append(oppositionCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}