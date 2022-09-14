package com.example.dhenne.springbootservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("spring-boot-service")
@Data
public class SpringBootServiceProperties {

    private String version;

    private String environment;
    private String globalParam1;
    private String localParam2;

}
