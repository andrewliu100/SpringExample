/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.model.TextBook
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 7:28 PM
 */
package com.geekspearls.mvc.jackson.server.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Map;

/**
 * @author Andrew
 */
@JsonTypeName("TextBook")
public class TextBook extends AbstractBook {

    @JsonProperty
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + "Subject: " + subject;
    }
}
