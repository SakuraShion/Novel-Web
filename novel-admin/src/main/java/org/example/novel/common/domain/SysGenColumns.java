package org.example.novel.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sys_gen_columns
 */
@TableName(value ="sys_gen_columns")
@Data
public class SysGenColumns implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 列名
     */
    private String columnName;

    /**
     * 列类型
     */
    private String columnType;

    /**
     * 映射java类型
     */
    private String javaType;

    /**
     * 列注释
     */
    private String columnComment;

    /**
     * 列排序（升序）
     */
    private Integer columnSort;

    /**
     * 鍒楁爣绛惧悕
     */
    private String columnLabel;

    /**
     * 页面显示类型：1、文本框 2、下拉框 3、数值4、日期 5、文本域6、富文本 7、上传图片【单文件】 8、上传图片【多文件】9、上传文件【单文件】 10、上传文件【多文件】11、隐藏域 12、不显示
     */
    private Integer pageType;

    /**
     * 是否必填
     */
    private Integer isRequired;

    /**
     * 页面显示为下拉时使用，字典类型从字典表中取出
     */
    private String dictType;

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
        SysGenColumns other = (SysGenColumns) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()))
            && (this.getColumnName() == null ? other.getColumnName() == null : this.getColumnName().equals(other.getColumnName()))
            && (this.getColumnType() == null ? other.getColumnType() == null : this.getColumnType().equals(other.getColumnType()))
            && (this.getJavaType() == null ? other.getJavaType() == null : this.getJavaType().equals(other.getJavaType()))
            && (this.getColumnComment() == null ? other.getColumnComment() == null : this.getColumnComment().equals(other.getColumnComment()))
            && (this.getColumnSort() == null ? other.getColumnSort() == null : this.getColumnSort().equals(other.getColumnSort()))
            && (this.getColumnLabel() == null ? other.getColumnLabel() == null : this.getColumnLabel().equals(other.getColumnLabel()))
            && (this.getPageType() == null ? other.getPageType() == null : this.getPageType().equals(other.getPageType()))
            && (this.getIsRequired() == null ? other.getIsRequired() == null : this.getIsRequired().equals(other.getIsRequired()))
            && (this.getDictType() == null ? other.getDictType() == null : this.getDictType().equals(other.getDictType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        result = prime * result + ((getColumnName() == null) ? 0 : getColumnName().hashCode());
        result = prime * result + ((getColumnType() == null) ? 0 : getColumnType().hashCode());
        result = prime * result + ((getJavaType() == null) ? 0 : getJavaType().hashCode());
        result = prime * result + ((getColumnComment() == null) ? 0 : getColumnComment().hashCode());
        result = prime * result + ((getColumnSort() == null) ? 0 : getColumnSort().hashCode());
        result = prime * result + ((getColumnLabel() == null) ? 0 : getColumnLabel().hashCode());
        result = prime * result + ((getPageType() == null) ? 0 : getPageType().hashCode());
        result = prime * result + ((getIsRequired() == null) ? 0 : getIsRequired().hashCode());
        result = prime * result + ((getDictType() == null) ? 0 : getDictType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tableName=").append(tableName);
        sb.append(", columnName=").append(columnName);
        sb.append(", columnType=").append(columnType);
        sb.append(", javaType=").append(javaType);
        sb.append(", columnComment=").append(columnComment);
        sb.append(", columnSort=").append(columnSort);
        sb.append(", columnLabel=").append(columnLabel);
        sb.append(", pageType=").append(pageType);
        sb.append(", isRequired=").append(isRequired);
        sb.append(", dictType=").append(dictType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}