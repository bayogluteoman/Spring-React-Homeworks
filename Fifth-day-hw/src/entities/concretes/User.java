package entities.concretes;

import entities.abstracts.Entity;

public class User implements Entity {
    private int ID;
    private String first_name;
    private String last_name;
    private String mail;
    private String password;

    public User(){

    }

    public User(int ID, String first_name, String last_name, String mail, String password) {
        this.ID = ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mail = mail;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
