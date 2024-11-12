package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.User;

public class UserDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/userappdb"; 
    private String jdbcUserName = "root";
    private String jdbcPassword = "mggandhi";

    private static final String INSERT_USER_SQL = "INSERT INTO users (user_name, email_id, pass_word, age) VALUES (?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE user_id = ?;";

    public UserDAO() {
        super();
    }

    // Establish DB connection
    public Connection getConnection() {
        Connection connection = null;
        try {
            // Check if the driver is available
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded successfully.");

            // Try connecting to the database
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
            if (connection != null) {
                System.out.println("Database connection successful.");
            } else {
                System.out.println("Database connection failed.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }


    public boolean insertUser(User newUser) {
        boolean rowInserted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, newUser.getUserName());
            preparedStatement.setString(2, newUser.getEmailId());
            preparedStatement.setString(3, newUser.getPassWord());
            preparedStatement.setInt(4, newUser.getAge());
            rowInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }




    // Select a user by ID
    public User selectUser(int userId) {
        User user = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setEmailId(resultSet.getString("email_id"));
                user.setPassWord(resultSet.getString("pass_word"));
                user.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Select all users
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                String emailId = resultSet.getString("email_id");
                String passWord = resultSet.getString("pass_word");
                int age = resultSet.getInt("age");

                users.add(new User(userId, userName, emailId, passWord, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Delete a user by ID
    public boolean deleteUser(int userId) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, userId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
