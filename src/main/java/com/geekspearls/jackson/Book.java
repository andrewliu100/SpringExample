/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.jackson.Book
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 7:28 PM
 */
package com.geekspearls.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Andrew
 */
//@JsonTypeName("Book")
//@JsonDeserialize(using = CustomDeserializer.class)
public class Book extends BaseBook {

    @JsonCreator
    public Book(@JsonProperty(value = "reviews") Map<Object, Object> reviews) {
        super(reviews);
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
