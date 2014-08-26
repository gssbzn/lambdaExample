package com.borabora;

import java.util.Date;

/**
 * Created by epauser on 13/08/14.
 */
public class Sample {
    private Date date;
    private String data;

    public Sample(String data) {
        this.date = new Date();
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "(" + date +
                ", " + data +
                ')';
    }
}
