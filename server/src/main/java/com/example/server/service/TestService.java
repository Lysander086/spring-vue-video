package com.example.server.service;


import com.example.server.domain.Test;
import com.example.server.domain.TestExample;
import com.example.server.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

//    for test
    public List<Test> list() {
        TestExample example = new TestExample();
        example.createCriteria().andIdEqualTo("1"); // where 语句
        example.setOrderByClause("id asc"); // order by

        return testMapper.selectByExample(example);
    }


}