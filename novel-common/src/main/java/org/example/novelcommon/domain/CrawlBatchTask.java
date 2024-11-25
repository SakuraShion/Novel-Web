package org.example.novelcommon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 批量抓取任务表
 * @TableName crawl_batch_task
 */
@TableName(value ="crawl_batch_task")
@Data
public class CrawlBatchTask implements Serializable {
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
     * 成功抓取数量
     */
    private Integer crawlCountSuccess;

    /**
     * 目标抓取数量
     */
    private Integer crawlCountTarget;

    /**
     * 任务状态，1：正在运行，0已停止
     */
    private Integer taskStatus;

    /**
     * 任务开始时间
     */
    private Date startTime;

    /**
     * 任务结束时间
     */
    private Date endTime;

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
        CrawlBatchTask other = (CrawlBatchTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSourceId() == null ? other.getSourceId() == null : this.getSourceId().equals(other.getSourceId()))
            && (this.getCrawlCountSuccess() == null ? other.getCrawlCountSuccess() == null : this.getCrawlCountSuccess().equals(other.getCrawlCountSuccess()))
            && (this.getCrawlCountTarget() == null ? other.getCrawlCountTarget() == null : this.getCrawlCountTarget().equals(other.getCrawlCountTarget()))
            && (this.getTaskStatus() == null ? other.getTaskStatus() == null : this.getTaskStatus().equals(other.getTaskStatus()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSourceId() == null) ? 0 : getSourceId().hashCode());
        result = prime * result + ((getCrawlCountSuccess() == null) ? 0 : getCrawlCountSuccess().hashCode());
        result = prime * result + ((getCrawlCountTarget() == null) ? 0 : getCrawlCountTarget().hashCode());
        result = prime * result + ((getTaskStatus() == null) ? 0 : getTaskStatus().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
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
        sb.append(", crawlCountSuccess=").append(crawlCountSuccess);
        sb.append(", crawlCountTarget=").append(crawlCountTarget);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}