package com.login;

import java.util.Objects;

public class Student {
    private String username;
    private String pwd;

    public Student(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public Student() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(username, student.username) &&
                Objects.equals(pwd, student.pwd);
    }

}
