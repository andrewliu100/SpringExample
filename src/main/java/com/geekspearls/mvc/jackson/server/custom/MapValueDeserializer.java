/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.custom.MapValueDeserializer
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 9:29 PM
 */
package com.geekspearls.mvc.jackson.server.custom;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @author Andrew
 */
public class MapValueDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
//        if (node.isTextual() && node.asText().contains("@")) {
//            String dateVal = node.asText();
//            Long longVal = Long.valueOf(dateVal.substring(0, dateVal.indexOf("@")));
//            return new Date(longVal);
//        } else {
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.readValue(node.toString(), Object.class);
//        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE, JsonTypeInfo.As.WRAPPER_ARRAY);
        return mapper.readValue(node.toString(), new TypeReference<Date>(){});
    }
}
