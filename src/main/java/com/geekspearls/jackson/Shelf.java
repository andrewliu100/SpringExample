/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.jackson.Shelf
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 7:27 PM
 */
package com.geekspearls.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.*;

/**
 * @author Andrew
 */
public class Shelf {

    @JsonProperty
    private Object name;

    @JsonProperty
    /**
     * Customized deserializer only works when there is no @JsonTypeInfo annotated for the same json property!!!!
     *
     * The below @JsonDeserialize WON'T work because @JsonTypeInfo annotated IBook!!!
     * MUST use  module.addDeserializer(Book.class, new CustomDeserializer()); to make the CustomDeserializer to work!
     */
    //@JsonDeserialize(contentUsing = CustomDeserializer.class)
    private List<IBook> books = new LinkedList<>();


    public void setBooks(List<IBook> books) {
        this.books = books;
    }
    @JsonIgnore
    public void setBooks(Map<String,Book> result) {
        for (Map.Entry<String, Book> en : result.entrySet()) {
            this.books.add(en.getValue());
        }
    }

    public List<IBook> getBooks() {
        return this.books;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name ->" + name + "\n");
        for (IBook book : books) {
            sb.append(book.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
