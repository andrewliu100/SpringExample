/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.jackson.BaseBook
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 9:19 PM
 */
package com.geekspearls.jackson;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Andrew
 */
@JsonTypeName("BaseBook")
public class BaseBook implements IBook {

    @JsonProperty
    //@JsonSerialize(contentUsing = MapValueSerializer.class)
    @JsonDeserialize(as = HashMap.class, contentUsing = MapValueDeserializer.class)
    /**
     * The MapValueDeserializer WON'T work because of @JsonTypeInfo
     * Annotation @JsonTypeInfo cannot be used with @JsonSerialize and @JsonDeserialize!!!
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    private Map<Object, Object> reviews;

    @JsonCreator
    public BaseBook(Map<Object, Object> map) {
        this.reviews = map;
    }

    public Map<Object, Object> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Object, Object> review : getReviews().entrySet()) {
            sb.append(review.getKey() + " -> " + review.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }
}
