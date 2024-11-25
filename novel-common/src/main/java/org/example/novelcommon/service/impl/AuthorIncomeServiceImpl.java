package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.AuthorIncome;
import org.example.novelcommon.mapper.AuthorIncomeMapper;
import org.example.novelcommon.service.AuthorIncomeService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【author_income(稿费收入统计表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class AuthorIncomeServiceImpl extends ServiceImpl<AuthorIncomeMapper, AuthorIncome>
    implements AuthorIncomeService {

}




