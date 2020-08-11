package com.dlq.optional;

/**
 *@program: Java_New_Feature
 *@description:
 *@author: Hasee
 *@create: 2020-08-11 20:35
 */
public class Boy {

    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
