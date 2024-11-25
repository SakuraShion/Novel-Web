package org.example.novelcommon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 作者表
 * @TableName author
 */
@TableName(value ="author")
@Data
public class Author implements Serializable {
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
     * 0：正常，1：封禁
     */
    private Integer status;

    /**
     * 创建时间
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
        Author other = (Author) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getInviteCode() == null ? other.getInviteCode() == null : this.getInviteCode().equals(other.getInviteCode()))
            && (this.getPenName() == null ? other.getPenName() == null : this.getPenName().equals(other.getPenName()))
            && (this.getTelPhone() == null ? other.getTelPhone() == null : this.getTelPhone().equals(other.getTelPhone()))
            && (this.getChatAccount() == null ? other.getChatAccount() == null : this.getChatAccount().equals(other.getChatAccount()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getWorkDirection() == null ? other.getWorkDirection() == null : this.getWorkDirection().equals(other.getWorkDirection()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getInviteCode() == null) ? 0 : getInviteCode().hashCode());
        result = prime * result + ((getPenName() == null) ? 0 : getPenName().hashCode());
        result = prime * result + ((getTelPhone() == null) ? 0 : getTelPhone().hashCode());
        result = prime * result + ((getChatAccount() == null) ? 0 : getChatAccount().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getWorkDirection() == null) ? 0 : getWorkDirection().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", inviteCode=").append(inviteCode);
        sb.append(", penName=").append(penName);
        sb.append(", telPhone=").append(telPhone);
        sb.append(", chatAccount=").append(chatAccount);
        sb.append(", email=").append(email);
        sb.append(", workDirection=").append(workDirection);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}