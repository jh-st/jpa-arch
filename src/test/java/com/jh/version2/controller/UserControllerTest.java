package com.jh.version2.controller;

import com.jh.version2.entity.User;
import com.jh.version2.service.ResponseService;
import com.jh.version2.service.team.TeamService;
import com.jh.version2.service.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.persistence.EntityManager;

import static com.jh.version2.util.ApiDocumentUtils.getDocumentRequest;
import static com.jh.version2.util.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@AutoConfigureRestDocs
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntityManager em;

    @MockBean
    private ResponseService responseService;

    @MockBean
    private UserService userService;

    @MockBean
    private TeamService teamService;

    @Test
    @DisplayName("단건 유저 조회")
    public void getUser() throws Exception {

        // given
        final User user = User.builder()
                .name("test1")
                .age(0)
                .team(teamService.findById(1L))
                .build();

        given(userService.findById(1L)).willReturn(user);

        // when
        final ResultActions result = this.mockMvc.perform(
                RestDocumentationRequestBuilders.get("/api/v1/user/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        result.andExpect(status().isOk())
                .andDo(document("user/get-user",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("id").description("아이디")
                        ),
                        /*requestFields(
                        ),*/
                        responseFields(
                                fieldWithPath("userId").type(JsonFieldType.STRING).description("ID"),
                                fieldWithPath("userName").type(JsonFieldType.STRING).description("이름")
                        )
                ));
    }

}