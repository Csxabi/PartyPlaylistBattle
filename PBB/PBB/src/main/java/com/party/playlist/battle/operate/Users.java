package com.party.playlist.battle.operate;

import com.fasterxml.jackson.databind.JsonNode;
import com.party.playlist.battle.game.User;
import com.party.playlist.battle.connections.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Users {

    //Authentication
    public User authenticate(JsonNode requestBody) {

        String username = requestBody.get("Username").asText();
        String password = requestBody.get("Password").asText();
        if (validation(username, password)) {
            return new User(username, password);
        }
        return new User();
    }

    //Validation
    private boolean validation(String username, String password) {
        if (username == null || password == null || username.equals("") || password.equals("")) {
            return false;
        }
        return true;
    }

    //Register User adding him in the DB
    public User registerUser(JsonNode requestBody) {
        try {
            final Connection dbConnection = DBConnection.getInstance().createDbConnection();
            PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO user (username,password) VALUES(?,?);");
            String username = requestBody.get("Username").asText();
            String password = requestBody.get("Password").asText();
            User user = new User(username, password);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new User();
    }
}
