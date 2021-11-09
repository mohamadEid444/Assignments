package com.example.assignment1.model;

import java.util.List;

public interface TeamInterface {
     String[] getTeams();
     List<FootballTeam> getTeamsList();
    public FootballTeam search(String name);
}
