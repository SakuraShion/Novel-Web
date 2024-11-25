package org.example.novel.common.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author：hb
 * @Package：org.example.novel.common.domain
 * @Project：my
 * @Date：22/11/2024 10:08 am
 *
 */
@Data
public class TableDO {
    private String tableName;
    //表的备注
    private String comments;
    //表的主键
    private SysGenColumns pk;
    //表的列名(不包含主键)
    private List<SysGenColumns> columns;

    //类名(第一个字母大写)，如：sys_user => SysUser
    private String className;
    //类名(第一个字母小写)，如：sys_user => sysUser
    private String classname;
}
