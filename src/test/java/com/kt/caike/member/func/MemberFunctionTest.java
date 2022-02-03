package com.kt.caike.member.func;

import com.kt.caike.member.controller.MemberRestController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class MemberFunctionTest {

    @Autowired
    MemberRestController memberController;

    @Autowired
    MockMvc mockMvc;

    @Test
    @Transactional
    @DisplayName("저장 후 전체 데이터 조회허여 데이터가 잘 들어 갔는지 확인")
    void saveAndFindAll() throws Exception{
/*

        // "박동현" 신규 멤버 생성 후 Post 요청하여 데이터 저장
        MemberDto newMemberDto = MemberDto.builder()
                .name("박동현")
                .email("parkdonghyun@gmail.com")
                .password("1234").build();

        String jsonData = new Gson().toJson(newMemberDto);

        mockMvc.perform(post("/user/member")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
                .andExpect(status().isCreated());

        // 전체 조회하여 저장된 데이터를 확인
        MvcResult mvcResult = mockMvc.perform(get("/user/member"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String jsonResult = mvcResult.getResponse().getContentAsString();

        boolean isContainMember = false;
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(jsonResult).getAsJsonArray();
        Gson gson = new Gson();
        for(JsonElement jsonElement : jsonArray) {
            MemberDto memberDto = gson.fromJson(jsonElement, MemberDto.class);
            if("박동현".equals(memberDto)){
                isContainMember = true;
                break;
            }
        }

        assertThat(isContainMember).isTrue();
*/

    }

    @Test
    void findMemberById() {
    }

    @Test
    void saveMember() {
    }
}