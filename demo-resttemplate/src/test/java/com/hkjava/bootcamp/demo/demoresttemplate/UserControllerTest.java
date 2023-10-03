package com.hkjava.bootcamp.demo.demoresttemplate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import com.hkjava.bootcamp.demo.demoresttemplate.model.User;
import com.hkjava.bootcamp.demo.demoresttemplate.service.UserService;

// This is another Testing Environment
// Which may not require a full context

@WebMvcTest // @AutoConfigureMockMvc
// have the webserver function
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // @Autowired
    // UserService userService;
    // ^ cannot write the real service becuase there would have no real bean for
    // this test class to inject into here

    @MockBean
    private UserService userService;

    @Test
    void testGetUsers() throws Exception {
        User user1 = new User(1, "John", "John Lau", "John@gmail.com", null, null, null, null);
        User user2 = new User(2, "May", "May Chan", "May@gmail.com", null, null, null, null);
        Mockito.when(userService.findAll()).thenReturn(List.of(user1, user2));
        // ResultActions mvcResult =
        // mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users"));

        mockMvc.perform(get("/api/v1/users")) // get = doing @getmapping
                .andExpect(status().isOk()) // HTTP 200
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code").value(20000))
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.data[0].id").value(1))
                .andExpect(jsonPath("$.data[0].name").value("John"))
                .andExpect(jsonPath("$.data[1].id").value(2))
                .andExpect(jsonPath("$.data[1].name").value("May"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testEmptyUsers() throws Exception {
        Mockito.when(userService.findAll()).thenReturn(null);

        // ResultActions mvcResult = mockMvc.perform(get("/api/v1/users"));

        mockMvc.perform(get("/api/v1/users")) //
                .andExpect(status().isBadRequest()) // HTTP 400
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.code").value(40001)) //
                .andExpect(
                        jsonPath("$.message").value("JsonPlaceHolder RestClientException")) //
                .andExpect(jsonPath("$.data").doesNotExist())
                .andDo(MockMvcResultHandlers.print());
    }
}
