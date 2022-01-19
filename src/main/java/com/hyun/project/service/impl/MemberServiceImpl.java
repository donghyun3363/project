package com.hyun.project.service.impl;

import com.hyun.project.mapper.MemberMapper;
import com.hyun.project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memeberMapper;

    @Override
    public Map<String, Object> selectMember() {
        return memeberMapper.selectMember();
    }
}
