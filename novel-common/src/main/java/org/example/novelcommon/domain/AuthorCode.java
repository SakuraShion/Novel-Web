package org.example.novelcommon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 作家邀请码表
 * @TableName author_code
 */
@TableName(value ="author_code")
@Data
public class AuthorCode implements Serializable {
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
     * 有效时间
     */
    private Date validityTime;

    /**
     * 是否使用过，0：未使用，1:使用过
     */
    private Integer isUse;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人ID
     */
    private Long createUserId;

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
        AuthorCode other = (AuthorCode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInviteCode() == null ? other.getInviteCode() == null : this.getInviteCode().equals(other.getInviteCode()))
            && (this.getValidityTime() == null ? other.getValidityTime() == null : this.getValidityTime().equals(other.getValidityTime()))
            && (this.getIsUse() == null ? other.getIsUse() == null : this.getIsUse().equals(other.getIsUse()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInviteCode() == null) ? 0 : getInviteCode().hashCode());
        result = prime * result + ((getValidityTime() == null) ? 0 : getValidityTime().hashCode());
        result = prime * result + ((getIsUse() == null) ? 0 : getIsUse().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
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
        sb.append(", validityTime=").append(validityTime);
        sb.append(", isUse=").append(isUse);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}