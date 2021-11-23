package com.example.pizzadelivery;

public class Users {
    private int id;
    private String name;
    private String email;
    private String password;
    public  int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getMail() {
        return email;
    }
    public void setMail(String mail){
        this.email = mail;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String pass){
        this.password = pass;
    }

}
