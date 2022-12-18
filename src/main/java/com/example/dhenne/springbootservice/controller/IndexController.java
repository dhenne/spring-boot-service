package com.example.dhenne.springbootservice.controller;


import com.example.dhenne.springbootservice.controller.dto.IndexDto;
import com.example.dhenne.springbootservice.properties.SpringBootServiceProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final SpringBootServiceProperties springBootServiceProperties;

    public static final String HELLO_APPLICATION = "Hello Application ";

    @GetMapping("/")
    public IndexDto index() {
        return IndexDto.builder()
                .message(HELLO_APPLICATION + springBootServiceProperties.getVersion())
                .environment(springBootServiceProperties.getEnvironment())
                .globalParam1(springBootServiceProperties.getGlobalParam1())
                .localParam2(springBootServiceProperties.getLocalParam2())
                .build();
    }


}
