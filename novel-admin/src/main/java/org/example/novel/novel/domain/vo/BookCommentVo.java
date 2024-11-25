package org.example.novel.novel.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author：hb
 * @Package：org.example.novel.novel.domain.vo
 * @Project：my
 * @Date：23/11/2024 10:35 am
 */
@Data
public class BookCommentVo {

    private Long bookId;

    private Long userId;

    /**
     * 评价内容
     */
    private String commentContent;

    /**
     * 审核状态，0：待审核，1：审核通过，2：审核不通过
     */
    private Integer auditStatus;

    /**
     * 评价时间
     */
    private Date createTime;


    /**
     * 支持数量
     */
    private Integer supportCount;

    /**
     * 反对数量
     */
    private Integer oppositionCount;

    private String userName;
}
