package org.example.novel.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.common.domain
 * @Project：my
 * @Date：22/11/2024 10:04 am
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDO<T> {
    private Integer offset;
    private int limit;
    private int total;
    private Map<String, Object> params;
    private String param;
    private List<T> rows;

}
