/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.custom.CustomDeserializer
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 8:02 PM
 */
package com.geekspearls.mvc.jackson.server.custom;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.geekspearls.mvc.jackson.server.model.TextBook;

import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Andrew
 */
public class CustomDeserializer extends JsonDeserializer<TextBook> {
    @Override
    public TextBook deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
       JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        ObjectMapper mapper = (ObjectMapper)jsonParser.getCodec();
        TextBook book = mapper.readValue(node.toString(), TextBook.class);

        Map<Object, Object> reviews = new Hashtable<>();
       // reviews.putAll(book.getProperties());
        return book;
    }

    /**
     * @author Andrew
     */
    public static class MapValueSerializer extends JsonSerializer<Object> {
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
}
