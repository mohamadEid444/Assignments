package com.example.assignment1.model;

public class FootballTeam {
    private String name;
    private String Country;
    private int trophies;

    public FootballTeam(){}

    public FootballTeam(String name, String country, int trophies) {
        this.name = name;
        Country = country;
        this.trophies = trophies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }
}
