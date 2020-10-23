package com.jh.version2.function.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.team.service.TeamService;
import com.jh.version2.domain.user.dto.UserDto;
import com.jh.version2.domain.user.entity.User;
import com.jh.version2.domain.user.service.UserService;
import com.jh.version2.function.service.ResponseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static com.jh.version2.util.ApiDocumentUtils.getDocumentRequest;
import static com.jh.version2.util.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
@Transactional
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    EntityManager em;

    @Autowired
    ResponseService responseService;

    @Autowired
    UserService userService;

    @Autowired
    TeamService teamService;

    @Test
    @DisplayName("단건 유저 조회 V1")
    public void getUserV1() throws Exception {

        final Team team = Team.builder()
                .name("A-TEAM")
                .score(1500)
                .build();

        final User user = User.builder()
                .name("test1")
                .age(0)
                .team(team)
                .build();

        final UserDto userDto = UserDto.of(user);
        userDto.setUserId(1L);
        userDto.getTeam().setTeamId(1L);

        // when
        final ResultActions result = this.mockMvc.perform(
                get("/api/v1/user/{id}", userDto.getUserId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        result.andExpect(status().isOk())
                .andDo(document("user/get-user",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("id").description("ID")
                        ),
                        /*requestFields(
                        ),*/
                        responseFields(
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 아이디")
                                , fieldWithPath("userName").type(JsonFieldType.STRING).description("유저 이름")
                                , fieldWithPath("userAge").type(JsonFieldType.NUMBER).description("유저 나이")
                                , fieldWithPath("team.teamId").type(JsonFieldType.NUMBER).description("팀 아이디")
                                , fieldWithPath("team.teamName").type(JsonFieldType.STRING).description("팀 이름")
                                , fieldWithPath("team.teamScore").type(JsonFieldType.NUMBER).description("팀 점수")
                        )
                ));
    }

}