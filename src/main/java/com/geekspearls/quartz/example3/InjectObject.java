/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.quartz.example3.InjectObject
 *
 * @author Andrew Liu
 * @since 2015 15/08/2015 4:05 PM
 */
package com.geekspearls.quartz.example3;

/**
 * @author Andrew
 */
public class InjectObject {
    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
