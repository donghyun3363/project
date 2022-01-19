package com.hyun.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapper {

    public Map<String, Object> selectMember();

}
