package org.example.novelcommon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 爬虫源表
 * @TableName crawl_source
 */
@TableName(value ="crawl_source")
@Data
public class CrawlSource implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 源站名
     */
    private String sourceName;

    /**
     * 爬取规则（json串）
     */
    private String crawlRule;

    /**
     * 爬虫源状态，0：关闭，1：开启
     */
    private Integer sourceStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
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
        CrawlSource other = (CrawlSource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSourceName() == null ? other.getSourceName() == null : this.getSourceName().equals(other.getSourceName()))
            && (this.getCrawlRule() == null ? other.getCrawlRule() == null : this.getCrawlRule().equals(other.getCrawlRule()))
            && (this.getSourceStatus() == null ? other.getSourceStatus() == null : this.getSourceStatus().equals(other.getSourceStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSourceName() == null) ? 0 : getSourceName().hashCode());
        result = prime * result + ((getCrawlRule() == null) ? 0 : getCrawlRule().hashCode());
        result = prime * result + ((getSourceStatus() == null) ? 0 : getSourceStatus().hashCode());
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
        sb.append(", sourceName=").append(sourceName);
        sb.append(", crawlRule=").append(crawlRule);
        sb.append(", sourceStatus=").append(sourceStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}