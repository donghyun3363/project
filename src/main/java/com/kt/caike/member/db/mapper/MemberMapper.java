package com.kt.caike.member.db.mapper;

import com.kt.caike.member.db.entity.Member;
import com.kt.caike.member.dto.MemberDto;
import com.kt.caike.member.dto.MemberSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    public List<MemberDto> searchMember(Map map);

    public Integer getAllCntMember(Map map);

}
