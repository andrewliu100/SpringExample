/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.config.AppConfig
 *
 * @author Andrew Liu
 * @since 2015 9/10/2015 9:21 PM
 */
package com.geekspearls.mvc.jackson.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekspearls.gc.GCMonitor;
import com.geekspearls.mvc.jackson.common.ObjectMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author Andrew
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.geekspearls.mvc.jackson.server")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // equivalent to <mvc:message-converters>
        converters.add(converter());
    }

    @Bean
    public MappingJackson2HttpMessageConverter converter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return ObjectMapperFactory.getObjectMapper();
    }

    @Bean(initMethod = "registerGCMonitor")
    public GCMonitor gcMonitor() {
        return new GCMonitor();
    }
}
