package com.geekspearls.mvc.jackson.server.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Map;

/**
 * @author Andrew
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonSubTypes({@JsonSubTypes.Type(value = AbstractBook.class,  name = "AbstractBook"),
                @JsonSubTypes.Type(value = TextBook.class,  name = "TextBook"),
                @JsonSubTypes.Type(value = ChildrenBook.class,  name = "ChildrenBook")})
public interface IBook {

    Map<String, Object> getProperties();
    void setProperties(Map<String, Object> properties);
}
