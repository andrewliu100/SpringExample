/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.model.InStock
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 7:27 PM
 */
package com.geekspearls.mvc.jackson.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

/**
 * @author Andrew
 */
public class InStock {

    @JsonProperty
    private String store;

    @JsonProperty
    /**
     * Customized deserializer only works when there is no @JsonTypeInfo annotated for the same json property!!!!
     *
     * The below @JsonDeserialize WON'T work because @JsonTypeInfo annotated IBook!!!
     * MUST use  module.addDeserializer(TextBook.class, new CustomDeserializer()); to make the CustomDeserializer to work!
     */
    //@JsonDeserialize(contentUsing = CustomDeserializer.class)
    private List<IBook> books = new LinkedList<>();

    public void setBooks(List<IBook> books) {
        this.books = books;
    }

    public List<IBook> getBooks() {
        return this.books;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Store ->").append(store).append("\n");
        for (IBook book : books) {
            sb.append("book@").append(book.getClass().getName()).append("\n");
            sb.append(book.toString());
            sb.append("\n").append("=======================================\n");
        }
        return sb.toString();
    }
}
