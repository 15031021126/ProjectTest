package com.lohootech.modules.entity;

public class PersonCount {
    private  int man_count;
    private  int woman_count;

    @Override
    public String toString() {
        return "PersonCount{" +
                "womenCount=" + man_count +
                ", manCount=" + woman_count +
                '}';
    }

    public int getMan_count() {
        return man_count;
    }

    public void setMan_count(int man_count) {
        this.man_count = man_count;
    }

    public int getWoman_count() {
        return woman_count;
    }

    public void setWoman_count(int woman_count) {
        this.woman_count = woman_count;
    }

    public PersonCount(int man_count, int woman_count) {
        this.man_count = man_count;
        this.woman_count = woman_count;
    }
}
