/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.model.AbstractBook
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 9:19 PM
 */
package com.geekspearls.mvc.jackson.server.model;

import com.fasterxml.jackson.annotation.*;

import java.util.Map;

/**
 * @author Andrew
 */
@JsonTypeName("AbstractBook")
public abstract class AbstractBook implements IBook {

    @JsonProperty
    protected String title;

    @JsonProperty
    protected String isbn;

    @JsonProperty
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    protected Map<String, Object> properties;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(title).append("\n");
        sb.append("ISBN: ").append(isbn).append("\n");
        sb.append("Properties").append("@").append(properties.getClass().getName()).append("\n");
        for (Map.Entry<String, Object> property : getProperties().entrySet()) {
            sb.append(property.getKey())
            .append(" -> ")
            .append(property.getValue())
            .append("@")
            .append(property.getValue().getClass().getName());
            sb.append("\n");
        }
        return sb.toString();
    }
}
