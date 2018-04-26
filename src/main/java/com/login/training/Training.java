package com.login.training;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Training {
    @Id
    @GeneratedValue
    int id;
    String type;
    String date;
    double distance;
    double time;
    int pulse;
    String comment;


    public Training(int id, String type, String date, double distance, double time, int pulse, String comment){
        this.id = id;
        this.type = type;
        this.date = date;
        this.distance = distance;
        this.time = time;
        this.pulse = pulse;
        this.comment = comment;
    }

    public Training() {}

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public int getPulse() {
        return pulse;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", distance=" + distance +
                ", time=" + time +
                ", pulse=" + pulse +
                ", comment='" + comment + '\'' +
                '}';
    }
}
