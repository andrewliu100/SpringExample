/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.jackson.MapValueSerializer
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 9:56 PM
 */
package com.geekspearls.jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @author Andrew
 */
public class MapValueSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
       if (o instanceof Date) {
           Date d = (Date) o;
           ObjectMapper objectMapper = new ObjectMapper();
           objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE, JsonTypeInfo.As.WRAPPER_ARRAY);
           objectMapper.writeValue(jsonGenerator, d);
       } else {
           jsonGenerator.writeObject(o);
       }
    }
}
