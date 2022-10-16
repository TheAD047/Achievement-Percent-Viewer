package com.assignment1gc200489790.DBUtility;

import com.assignment1gc200489790.Models.Achievement;
import com.assignment1gc200489790.Models.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DBUtil {
    private static String user = "Arin200489790";
    private static String password = "YZhyn-tHO6";
    private static String url = "jdbc:mysql://172.31.22.43/Arin200489790";

    private static Connection startConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }
        catch (Exception e) {
            System.out.println("session not commenced...");
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Achievement> getAchievementsForGame(long gameID) {
        String sql = "SELECT * FROM achievements WHERE steamGameID = ? LIMIT 20";
        ArrayList<Achievement> achievements = new ArrayList<Achievement>();
        try(
                Connection connection = startConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ){
            statement.setLong(1, gameID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Achievement achievement = new Achievement(
                                                            resultSet.getInt("steamGameID"),
                                                            resultSet.getString("achievementName"),
                                                            resultSet.getDouble("percent")
                                                            );
                achievements.add(achievement);
            }

            return achievements;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Game> getGames() {
        String sql = "SELECT * FROM games";
        ArrayList<Game> games = new ArrayList<Game>();

        try(
                Connection connection = startConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ) {
            while (resultSet.next()) {
                Game game = new Game(
                                        resultSet.getInt("steamGameID"),
                                        resultSet.getString("gameName"),
                                        resultSet.getString("publisher"),
                                        resultSet.getInt("releaseYear")
                                        );
                games.add(game);
            }
            return games;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void insertAchievement(Game game, Achievement... achievements) {
        Arrays.stream(achievements).forEach(achievement -> {achievement.setSteamGameID(game.getSteamGameID());});
        String sql = "INSERT INTO achievements(steamGameID, achievementName, percent) VALUES(?, ?, ?)";

        Arrays.stream(achievements).forEach(achievement -> {
            if(!isAchievementPresent(achievement)) {
                try(
                        Connection connection = startConnection();
                        PreparedStatement statement = connection.prepareStatement(sql);
                        ) {
                    statement.setInt(1,(int) achievement.getSteamGameID());
                    statement.setString(2, achievement.getAchievementName());
                    statement.setDouble(3, achievement.getPercentPlayers());

                    statement.executeUpdate();

                    System.out.println("Achievement added...");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Achievement already exists..");
            }
        });
    }

    public static void insertGame(Game game) {
        String sql = "INSERT INTO games VALUES(?,?,?,?)";
        if(!isGamePresent(game)) {
            try(
                    Connection connection = startConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ){
                statement.setLong(1, game.getSteamGameID());
                statement.setString(2, game.getGameName());
                statement.setString(3, game.getPublisher());
                statement.setInt(4, game.getReleaseYear());

                statement.executeUpdate();

                System.out.println("Added Game..." + game);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Game Already Exists...");
        }
    }

    private static boolean isAchievementPresent(Achievement achievement) {
        String sql = "SELECT * FROM achievements WHERE achievementName = ? AND steamGameID = ?";
        try(
                Connection connection = startConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ){
            statement.setString(1, achievement.getAchievementName());
            statement.setLong(2, achievement.getSteamGameID());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
        catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private static boolean isGamePresent(Game game) {
        String sql = "SELECT * FROM games WHERE steamGameID = ? AND gameName = ?";
        try(
                Connection connection = startConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ){
            statement.setLong(1, game.getSteamGameID());
            statement.setString(2, game.getGameName());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
        catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
