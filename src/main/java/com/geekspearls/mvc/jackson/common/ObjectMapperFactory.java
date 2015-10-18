package com.geekspearls.mvc.jackson.common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekspearls.mvc.jackson.server.custom.MapTypeIdResolverBuilder;

/**
 * Created by Andrew on 17/10/2015.
 */
public class ObjectMapperFactory {

    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            MapTypeIdResolverBuilder mapResolverBuilder = new MapTypeIdResolverBuilder();
            mapResolverBuilder.init(JsonTypeInfo.Id.CLASS, null);
            mapResolverBuilder.inclusion(JsonTypeInfo.As.PROPERTY);
            objectMapper.setDefaultTyping(mapResolverBuilder);
        }
        return objectMapper;
    }
}
