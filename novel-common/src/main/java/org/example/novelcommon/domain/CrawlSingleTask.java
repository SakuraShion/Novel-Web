package org.example.novelcommon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 抓取单本小说任务表
 * @TableName crawl_single_task
 */
@TableName(value ="crawl_single_task")
@Data
public class CrawlSingleTask implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 爬虫源ID
     */
    private Integer sourceId;

    /**
     * 爬虫源名
     */
    private String sourceName;

    /**
     * 源站小说ID
     */
    private String sourceBookId;

    /**
     * 分类ID
     */
    private Integer catId;

    /**
     * 爬取的小说名
     */
    private String bookName;

    /**
     * 爬取的小说作者名
     */
    private String authorName;

    /**
     * 任务状态，0：失败，1：成功，2；未执行
     */
    private Integer taskStatus;

    /**
     * 已经执行次数，最多执行5次
     */
    private Integer excCount;

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
        CrawlSingleTask other = (CrawlSingleTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSourceId() == null ? other.getSourceId() == null : this.getSourceId().equals(other.getSourceId()))
            && (this.getSourceName() == null ? other.getSourceName() == null : this.getSourceName().equals(other.getSourceName()))
            && (this.getSourceBookId() == null ? other.getSourceBookId() == null : this.getSourceBookId().equals(other.getSourceBookId()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getBookName() == null ? other.getBookName() == null : this.getBookName().equals(other.getBookName()))
            && (this.getAuthorName() == null ? other.getAuthorName() == null : this.getAuthorName().equals(other.getAuthorName()))
            && (this.getTaskStatus() == null ? other.getTaskStatus() == null : this.getTaskStatus().equals(other.getTaskStatus()))
            && (this.getExcCount() == null ? other.getExcCount() == null : this.getExcCount().equals(other.getExcCount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSourceId() == null) ? 0 : getSourceId().hashCode());
        result = prime * result + ((getSourceName() == null) ? 0 : getSourceName().hashCode());
        result = prime * result + ((getSourceBookId() == null) ? 0 : getSourceBookId().hashCode());
        result = prime * result + ((getCatId() == null) ? 0 : getCatId().hashCode());
        result = prime * result + ((getBookName() == null) ? 0 : getBookName().hashCode());
        result = prime * result + ((getAuthorName() == null) ? 0 : getAuthorName().hashCode());
        result = prime * result + ((getTaskStatus() == null) ? 0 : getTaskStatus().hashCode());
        result = prime * result + ((getExcCount() == null) ? 0 : getExcCount().hashCode());
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
        sb.append(", sourceId=").append(sourceId);
        sb.append(", sourceName=").append(sourceName);
        sb.append(", sourceBookId=").append(sourceBookId);
        sb.append(", catId=").append(catId);
        sb.append(", bookName=").append(bookName);
        sb.append(", authorName=").append(authorName);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", excCount=").append(excCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}