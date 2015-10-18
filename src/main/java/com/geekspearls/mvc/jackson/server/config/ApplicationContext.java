/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.config.ApplicationContext
 *
 * @author Andrew Liu
 * @since 2015 9/10/2015 9:21 PM
 */
package com.geekspearls.mvc.jackson.server.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekspearls.mvc.jackson.common.ObjectMapperFactory;
import com.geekspearls.mvc.jackson.server.custom.MapTypeIdResolverBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Andrew
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.geekspearls.mvc.jackson.server")
public class ApplicationContext {

    @Bean(name = "customObjectMapper")
    public ObjectMapper objectMapper() {
        return ObjectMapperFactory.getObjectMapper();
    }
}
