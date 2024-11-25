package org.example.novel.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 数据权限管理
 * @TableName sys_data_perm
 */
@TableName(value ="sys_data_perm")
@Data
public class SysDataPerm implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 数据表名称
     */
    private String tableName;

    /**
     * 所属模块
     */
    private String moduleName;

    /**
     * 用户权限控制属性名
     */
    private String crlAttrName;

    /**
     * 数据表权限控制列名
     */
    private String crlColumnName;

    /**
     * 权限code，all_开头表示查看所有数据的权限，sup_开头表示查看下级数据的权限，own_开头表示查看本级数据的权限
     */
    private String permCode;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

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
        SysDataPerm other = (SysDataPerm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()))
            && (this.getModuleName() == null ? other.getModuleName() == null : this.getModuleName().equals(other.getModuleName()))
            && (this.getCrlAttrName() == null ? other.getCrlAttrName() == null : this.getCrlAttrName().equals(other.getCrlAttrName()))
            && (this.getCrlColumnName() == null ? other.getCrlColumnName() == null : this.getCrlColumnName().equals(other.getCrlColumnName()))
            && (this.getPermCode() == null ? other.getPermCode() == null : this.getPermCode().equals(other.getPermCode()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        result = prime * result + ((getModuleName() == null) ? 0 : getModuleName().hashCode());
        result = prime * result + ((getCrlAttrName() == null) ? 0 : getCrlAttrName().hashCode());
        result = prime * result + ((getCrlColumnName() == null) ? 0 : getCrlColumnName().hashCode());
        result = prime * result + ((getPermCode() == null) ? 0 : getPermCode().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", tableName=").append(tableName);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", crlAttrName=").append(crlAttrName);
        sb.append(", crlColumnName=").append(crlColumnName);
        sb.append(", permCode=").append(permCode);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}