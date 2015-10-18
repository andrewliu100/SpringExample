/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.model.AbstractBook
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 9:19 PM
 */
package com.geekspearls.mvc.jackson.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by Andrew on 18/10/2015.
 */
@JsonTypeName("ChildrenBook")
public class ChildrenBook extends AbstractBook {

    @JsonProperty
    private int minAge;

    @JsonProperty
    private int maxAge;

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return super.toString() + "Min Age: " + minAge + "\n" +
                "Max Age: " + maxAge;
    }
}
