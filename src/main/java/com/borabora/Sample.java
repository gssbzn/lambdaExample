package com.borabora;

import java.util.Date;

/**
 * Created by epauser on 13/08/14.
 */
public class Sample {
    private Date date;
    private Integer data;

    public Sample(Integer data) {
        this.date = new Date();
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "(" + date +
                ", " + data +
                ')';
    }
}
