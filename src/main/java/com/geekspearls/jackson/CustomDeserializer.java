/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.jackson.CustomDeserializer
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 8:02 PM
 */
package com.geekspearls.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Andrew
 */
public class CustomDeserializer extends JsonDeserializer<Book> {
    @Override
    public Book deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
       JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        ObjectMapper mapper = (ObjectMapper)jsonParser.getCodec();
        Book book = mapper.readValue(node.toString(), Book.class);

        Map<Object, Object> reviews = new Hashtable<>();
       // reviews.putAll(book.getReviews());
        return book;
    }
}
