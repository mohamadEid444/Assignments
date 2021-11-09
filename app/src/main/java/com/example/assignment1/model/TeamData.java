package com.example.assignment1.model;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TeamData implements TeamInterface{
ArrayList<FootballTeam> teams;
public TeamData(){
    teams = new ArrayList<>();
    teams.add(new FootballTeam("Real Madrid","Spain",91));
    teams.add(new FootballTeam("FC Barcelona","Spain",91));
    teams.add(new FootballTeam("Manchester United","England",71));
    teams.add(new FootballTeam("AlAhly","Egypt",108));
}
public String[] getTeams(){

   String names[] = {"Real Madrid","FC Barcelona","Manchester United","AlAhly"};
    return names;


}
public List<FootballTeam> getTeamsList(){
    return teams;
}
public FootballTeam search(String name){
    for (FootballTeam t : teams){
        if(t.getName().equals(name))
            return t;
    }
    return null;
}

}
