package com.geekspearls.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Map;

/**
 * @author Andrew
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonSubTypes({@JsonSubTypes.Type(value = BaseBook.class,  name = "BaseBook"),
        @JsonSubTypes.Type(value = Book.class,  name = "Book")})
public interface IBook {

    Map<Object, Object> getReviews();
}
