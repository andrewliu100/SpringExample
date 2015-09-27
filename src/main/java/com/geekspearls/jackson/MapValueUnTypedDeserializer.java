/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.jackson.MapValueUnTypedDeserializer
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 10:25 PM
 */
package com.geekspearls.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;

import java.io.IOException;

/**
 * @author Andrew
 */
public class MapValueUnTypedDeserializer extends UntypedObjectDeserializer {

    public Object deserialize(JsonParser jp, DeserializationContext context) throws IOException, JsonProcessingException {
        return super.deserialize(jp, context);
    }
}
