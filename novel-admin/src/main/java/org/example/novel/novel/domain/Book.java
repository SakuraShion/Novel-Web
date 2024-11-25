package org.example.novel.novel.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 小说表
 * @TableName book
 */
@TableName(value ="book")
@Data
public class Book implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 作品方向，0：男频，1：女频'
     */
    private Integer workDirection;

    /**
     * 分类ID
     */
    private Integer catId;

    /**
     * 分类名
     */
    private String catName;

    /**
     * 小说封面
     */
    private String picUrl;

    /**
     * 小说名
     */
    private String bookName;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 作者名
     */
    private String authorName;

    /**
     * 书籍描述
     */
    private String bookDesc;

    /**
     * 评分，预留字段
     */
    private Double score;

    /**
     * 书籍状态，0：连载中，1：已完结
     */
    private Integer bookStatus;

    /**
     * 点击量
     */
    private Long visitCount;

    /**
     * 总字数
     */
    private Integer wordCount;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 昨日订阅数
     */
    private Integer yesterdayBuy;

    /**
     * 最新目录ID
     */
    private Long lastIndexId;

    /**
     * 最新目录名
     */
    private String lastIndexName;

    /**
     * 最新目录更新时间
     */
    private Date lastIndexUpdateTime;

    /**
     * 是否收费，1：收费，0：免费
     */
    private Integer isVip;

    /**
     * 状态，0：入库，1：上架
     */
    private Integer status;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 爬虫源站ID
     */
    private Integer crawlSourceId;

    /**
     * 抓取的源站小说ID
     */
    private String crawlBookId;

    /**
     * 最后一次的抓取时间
     */
    private Date crawlLastTime;

    /**
     * 是否已停止更新，0：未停止，1：已停止
     */
    private Integer crawlIsStop;

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
        Book other = (Book) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWorkDirection() == null ? other.getWorkDirection() == null : this.getWorkDirection().equals(other.getWorkDirection()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getCatName() == null ? other.getCatName() == null : this.getCatName().equals(other.getCatName()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getBookName() == null ? other.getBookName() == null : this.getBookName().equals(other.getBookName()))
            && (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getAuthorName() == null ? other.getAuthorName() == null : this.getAuthorName().equals(other.getAuthorName()))
            && (this.getBookDesc() == null ? other.getBookDesc() == null : this.getBookDesc().equals(other.getBookDesc()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getBookStatus() == null ? other.getBookStatus() == null : this.getBookStatus().equals(other.getBookStatus()))
            && (this.getVisitCount() == null ? other.getVisitCount() == null : this.getVisitCount().equals(other.getVisitCount()))
            && (this.getWordCount() == null ? other.getWordCount() == null : this.getWordCount().equals(other.getWordCount()))
            && (this.getCommentCount() == null ? other.getCommentCount() == null : this.getCommentCount().equals(other.getCommentCount()))
            && (this.getYesterdayBuy() == null ? other.getYesterdayBuy() == null : this.getYesterdayBuy().equals(other.getYesterdayBuy()))
            && (this.getLastIndexId() == null ? other.getLastIndexId() == null : this.getLastIndexId().equals(other.getLastIndexId()))
            && (this.getLastIndexName() == null ? other.getLastIndexName() == null : this.getLastIndexName().equals(other.getLastIndexName()))
            && (this.getLastIndexUpdateTime() == null ? other.getLastIndexUpdateTime() == null : this.getLastIndexUpdateTime().equals(other.getLastIndexUpdateTime()))
            && (this.getIsVip() == null ? other.getIsVip() == null : this.getIsVip().equals(other.getIsVip()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCrawlSourceId() == null ? other.getCrawlSourceId() == null : this.getCrawlSourceId().equals(other.getCrawlSourceId()))
            && (this.getCrawlBookId() == null ? other.getCrawlBookId() == null : this.getCrawlBookId().equals(other.getCrawlBookId()))
            && (this.getCrawlLastTime() == null ? other.getCrawlLastTime() == null : this.getCrawlLastTime().equals(other.getCrawlLastTime()))
            && (this.getCrawlIsStop() == null ? other.getCrawlIsStop() == null : this.getCrawlIsStop().equals(other.getCrawlIsStop()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWorkDirection() == null) ? 0 : getWorkDirection().hashCode());
        result = prime * result + ((getCatId() == null) ? 0 : getCatId().hashCode());
        result = prime * result + ((getCatName() == null) ? 0 : getCatName().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getBookName() == null) ? 0 : getBookName().hashCode());
        result = prime * result + ((getAuthorId() == null) ? 0 : getAuthorId().hashCode());
        result = prime * result + ((getAuthorName() == null) ? 0 : getAuthorName().hashCode());
        result = prime * result + ((getBookDesc() == null) ? 0 : getBookDesc().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getBookStatus() == null) ? 0 : getBookStatus().hashCode());
        result = prime * result + ((getVisitCount() == null) ? 0 : getVisitCount().hashCode());
        result = prime * result + ((getWordCount() == null) ? 0 : getWordCount().hashCode());
        result = prime * result + ((getCommentCount() == null) ? 0 : getCommentCount().hashCode());
        result = prime * result + ((getYesterdayBuy() == null) ? 0 : getYesterdayBuy().hashCode());
        result = prime * result + ((getLastIndexId() == null) ? 0 : getLastIndexId().hashCode());
        result = prime * result + ((getLastIndexName() == null) ? 0 : getLastIndexName().hashCode());
        result = prime * result + ((getLastIndexUpdateTime() == null) ? 0 : getLastIndexUpdateTime().hashCode());
        result = prime * result + ((getIsVip() == null) ? 0 : getIsVip().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCrawlSourceId() == null) ? 0 : getCrawlSourceId().hashCode());
        result = prime * result + ((getCrawlBookId() == null) ? 0 : getCrawlBookId().hashCode());
        result = prime * result + ((getCrawlLastTime() == null) ? 0 : getCrawlLastTime().hashCode());
        result = prime * result + ((getCrawlIsStop() == null) ? 0 : getCrawlIsStop().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", workDirection=").append(workDirection);
        sb.append(", catId=").append(catId);
        sb.append(", catName=").append(catName);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", bookName=").append(bookName);
        sb.append(", authorId=").append(authorId);
        sb.append(", authorName=").append(authorName);
        sb.append(", bookDesc=").append(bookDesc);
        sb.append(", score=").append(score);
        sb.append(", bookStatus=").append(bookStatus);
        sb.append(", visitCount=").append(visitCount);
        sb.append(", wordCount=").append(wordCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", yesterdayBuy=").append(yesterdayBuy);
        sb.append(", lastIndexId=").append(lastIndexId);
        sb.append(", lastIndexName=").append(lastIndexName);
        sb.append(", lastIndexUpdateTime=").append(lastIndexUpdateTime);
        sb.append(", isVip=").append(isVip);
        sb.append(", status=").append(status);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", crawlSourceId=").append(crawlSourceId);
        sb.append(", crawlBookId=").append(crawlBookId);
        sb.append(", crawlLastTime=").append(crawlLastTime);
        sb.append(", crawlIsStop=").append(crawlIsStop);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}