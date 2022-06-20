package com.liu.managerial_system.dto;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/4 14:41
 */
public class TimetableDto {
    private String id;

    private String username;

    private String coursename;

    private String time;

    private String place;

    private String specialty;

    private String dayofweek;

    private String week;

    private String changed;

    private String oldid;

    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public String getOldid() {
        return oldid;
    }

    public void setOldid(String oldid) {
        this.oldid = oldid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", coursename=").append(coursename);
        sb.append(", time=").append(time);
        sb.append(", place=").append(place);
        sb.append(", specialty=").append(specialty);
        sb.append(", dayofweek=").append(dayofweek);
        sb.append(", week=").append(week);
        sb.append(", changed=").append(changed);
        sb.append(", oldid=").append(oldid);
        sb.append(", date=").append(date);
        sb.append("]");
        return sb.toString();
    }
}
