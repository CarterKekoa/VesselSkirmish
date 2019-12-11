package com.cartermooring.vesselskirmish;

import androidx.annotation.NonNull;

public class User {
    private String username;
    private int wins;
    private int loses;
    private int totalEnemySunkenShips;
    private int totalAllySunkenShips;

    public User(){
        username = "BLANK USERNAME";
        wins = -1;
        loses = -1;
        totalEnemySunkenShips = -1;
        totalAllySunkenShips = -1;
    }

    public User(String username, int wins, int loses, int totalEnemySunkenShips, int totalAllySunkShips){
        this.username = username;
        this.wins = wins;
        this.loses = loses;
        this.totalEnemySunkenShips = totalEnemySunkenShips;
        this.totalAllySunkenShips = totalAllySunkShips;
    }

    public String getUsername(){ return username; }
    public void setUsername(String username){this.username = username;}
    public int getWins(){return wins;}
    public void setWins(int wins){this.wins = wins;}
    public int getLoses(){return loses;}
    public void setLoses(int loses){this.loses = loses;}
    public int getTotalEnemySunkenShips(){return totalEnemySunkenShips;}
    public void setTotalEnemySunkenShips(int totalEnemySunkenShips){this.totalEnemySunkenShips = totalEnemySunkenShips;}
    public int getTotalAllySunkenShips(){return getTotalAllySunkenShips();}
    public void setTotalAllySunkenShips(int totalAllySunkenShips){this.totalAllySunkenShips = totalAllySunkenShips;}

    @Override
    public String toString() {
        return "Player: " + username + "\nWins: " + wins + "\nLoses: " + loses + "\nTotal Enemy Sunken Ships: "
                + totalEnemySunkenShips + "\nTotal Ally Sunken Ships: " + totalAllySunkenShips;
    }
}
