package org.example.novel.novel.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 作者表
 * @TableName book_author
 */
@TableName(value ="book_author")
@Data
public class BookAuthor implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 笔名
     */
    private String penName;

    /**
     * 手机号码
     */
    private String telPhone;

    /**
     * QQ或微信账号
     */
    private String chatAccount;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 作品方向，0：男频，1：女频
     */
    private Integer workDirection;

    /**
     * 0：待审核，1：审核通过，正常，2：审核不通过
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 申请人ID
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
        BookAuthor other = (BookAuthor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInviteCode() == null ? other.getInviteCode() == null : this.getInviteCode().equals(other.getInviteCode()))
            && (this.getPenName() == null ? other.getPenName() == null : this.getPenName().equals(other.getPenName()))
            && (this.getTelPhone() == null ? other.getTelPhone() == null : this.getTelPhone().equals(other.getTelPhone()))
            && (this.getChatAccount() == null ? other.getChatAccount() == null : this.getChatAccount().equals(other.getChatAccount()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getWorkDirection() == null ? other.getWorkDirection() == null : this.getWorkDirection().equals(other.getWorkDirection()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
        result = prime * result + ((getInviteCode() == null) ? 0 : getInviteCode().hashCode());
        result = prime * result + ((getPenName() == null) ? 0 : getPenName().hashCode());
        result = prime * result + ((getTelPhone() == null) ? 0 : getTelPhone().hashCode());
        result = prime * result + ((getChatAccount() == null) ? 0 : getChatAccount().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getWorkDirection() == null) ? 0 : getWorkDirection().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", inviteCode=").append(inviteCode);
        sb.append(", penName=").append(penName);
        sb.append(", telPhone=").append(telPhone);
        sb.append(", chatAccount=").append(chatAccount);
        sb.append(", email=").append(email);
        sb.append(", workDirection=").append(workDirection);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}