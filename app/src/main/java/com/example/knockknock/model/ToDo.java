package com.example.knockknock.model;

public class ToDo {

    private String noteid, title, description;
    private boolean mark;

    public ToDo() {
    }

    public ToDo(String noteid, String title, String description, boolean mark) {
        this.noteid = noteid;
        this.title = title;
        this.description = description;
        this.mark = mark;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }


    public String getNoteid() {
        return noteid;
    }

    public void setNoteid(String noteid) {
        this.noteid = noteid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
