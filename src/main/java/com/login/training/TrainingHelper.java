package com.login.training;

public class TrainingHelper {
    String date;
    String type;

    public TrainingHelper(String date, String type) {
        this.date = date;
        this.type = type;
    }

    public TrainingHelper() {}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TrainingHelper{" +
                "date='" + date + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
