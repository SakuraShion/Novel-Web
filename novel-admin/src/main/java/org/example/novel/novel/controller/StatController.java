package org.example.novel.novel.controller;

import lombok.SneakyThrows;
import org.example.novel.common.utils.DateUtils;
import org.example.novel.common.utils.R;
import org.example.novel.novel.service.AuthorService;
import org.example.novel.novel.service.BookService;
import org.example.novel.novel.service.OrderPayService;
import org.example.novel.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.novel.controller
 * @Project：my
 * @Date：25/11/2024 4:38 pm
 */
@RestController
@RequestMapping("/novel/stat")
public class StatController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderPayService orderPayService;

    @ResponseBody
    @GetMapping("/countSta")
    public R countUser() {
        Map map = new HashMap<>(0);
        int userCount = (int) userService.count(null);
        int authorCount = (int) authorService.count(null);
        int bookCount = (int) bookService.count(null);
        int orderCount = (int) orderPayService.count(null);
        return R.ok().put("userCount",userCount)
                .put("authorCount",authorCount)
                .put("bookCount",bookCount)
                .put("orderCount",orderCount);
    }


    @ResponseBody
    @GetMapping("/tableSta")
    @SneakyThrows
    public R tableSta() {
        Date currentDate = new Date();
        List<String> dateList = DateUtils.getDateList(7,currentDate);
        Date minDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateList.get(0));
        Map<Object,Object> userTableSta = userService.tableSta(minDate);
        Map<Object,Object> bookTableSta = bookService.tableSta(minDate);
        Map<Object,Object> authorTableSta = authorService.tableSta(minDate);
        Map<Object,Object> orderTableSta = orderPayService.tableSta(minDate);
        return R.ok().put("dateList",dateList)
                .put("userTableSta",userTableSta)
                .put("bookTableSta",bookTableSta)
                .put("authorTableSta",authorTableSta)
                .put("orderTableSta",orderTableSta)
                ;
    }
}
