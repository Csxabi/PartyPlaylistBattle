package com.party.playlist.battle.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    /**
     * Singleton pattern used
     */

    private static DBConnection single_instance = null;

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        if (single_instance == null) {
            single_instance = new DBConnection();
        }
        return single_instance;
    }

    public Connection createDbConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/pbb_db", "postgres", "postgre");
    }


}
