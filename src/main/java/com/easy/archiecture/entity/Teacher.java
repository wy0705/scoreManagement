package com.easy.archiecture.entity;

public class Teacher {
    private int tid;
    private String name;
    private String password;

    public Teacher() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Teacher(int tid, String name, String password) {
        this.tid = tid;
        this.name = name;
        this.password = password;
    }

    public Teacher(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
