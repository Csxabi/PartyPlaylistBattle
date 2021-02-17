package com.party.playlist.battle.domain;

public class User {
    private String Username;
    private String Password;
    private int  roundscorecounter;
    private String Image;
    private String Wins;
    private String Losses;

    public User(String username, String password) {
        Username = username;
        Password = password;
        this.roundscorecounter = 100;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getImage() {
        return Image;
    }

    public String getWins() {
        return Wins;
    }

    public String getLosses() {
        return Losses;
    }
}

