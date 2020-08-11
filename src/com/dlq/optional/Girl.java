package com.dlq.optional;

/**
 *@program: Java_New_Feature
 *@description:
 *@author: Hasee
 *@create: 2020-08-11 20:35
 */
public class Girl {

    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
