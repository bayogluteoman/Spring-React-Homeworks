package Entities;

import java.util.HashSet;
import java.util.Set;

public class User {

    private int id;
    private String tc_number;
    private String first_name;
    private String last_name;
    private int money;
    private Set<Game> hasGames = new HashSet<>();



    public User(int id, String tc_number, String first_name, String last_name) {
        this.id = id;
        this.tc_number = tc_number;
        this.first_name = first_name;
        this.last_name = last_name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTc_number() {
        return tc_number;
    }

    public void setTc_number(String tc_number) {
        this.tc_number = tc_number;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Set<Game> getHasGames() {
        return hasGames;
    }

    public void setHasGames(Set<Game> hasGames) {
        this.hasGames = hasGames;
    }
}
