package com.loki.demo110.model;

import javax.persistence.*;

@Entity
@Table(name="Person")
public class Person {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private int ID;
    @Column(name="UserName")
    private String userName;
    @Column(name = "PassWord")
    private String passWord;

    public Person(){

    }

    public Person(Integer id, String userName,String passWord) {
        this.ID=id;
        this.userName=userName;
        this.passWord=passWord;
    }

    public int getID() {
        return ID;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
