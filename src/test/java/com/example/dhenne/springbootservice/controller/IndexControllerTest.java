package com.example.dhenne.springbootservice.controller;

import com.example.dhenne.springbootservice.properties.SpringBootServiceProperties;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({IndexController.class, SpringBootServiceProperties.class})
class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SpringBootServiceProperties springBootServiceProperties;

    @Test
    @SneakyThrows
    void shouldReturnAnswerOnGet() {

        mockMvc.perform(
                        get("/")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.message", containsString(IndexController.HELLO_APPLICATION)),
                        jsonPath("$.message", containsString(springBootServiceProperties.getVersion()))
                );
    }

}