package domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: 杨斌
 * @Date: 2020/3/22 0022 0:36
 */

public class text {

    private int id;
    private String title;
    private String textAddress;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date creatTime;
    private String label;
    private int count;
    private String picture;

    @Override
    public String toString() {
        return "text{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", textAddress='" + textAddress + '\'' +
                ", creatTime=" + creatTime +
                ", label='" + label + '\'' +
                ", count=" + count +
                ", picture='" + picture + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextAddress() {
        return textAddress;
    }

    public void setTextAddress(String textAddress) {
        this.textAddress = textAddress;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
