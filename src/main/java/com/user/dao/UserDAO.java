package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.user;

public class UserDAO {

	private String jdbcURL = "jdbcURL:mysql://localhost:30006/userappdb";
	private String jdbcUserName = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_USER_SQL = "INSERT INTO users" + " (uname, email, country, passwd) VALUES "
			+ "(?,?,?,?);";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM USERS WHERE ID=?;";
	private static final String SELECT_ALL_USERS = "SELECT * FROM USERS;";
	private static final String DELETE_USERS_SQL = "DELETE FROM USERS WHERE ID=?;";
	private static final String UPDATE_USERS_SQL = "UPDATE USERS SET UNAME=?, EMAIL=?, COUNTRY=?, PASSWORD=? where ID=?;";

	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

	public void insertUser(user user) {
		UserDAO dao = new UserDAO();

		try (Connection connection = dao.getConnection()) {

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
			preparedStatement.setString(1, user.getUser_id());
			preparedStatement.setString(2, user.getUser_name());
			preparedStatement.setString(3, user.getEmail_id());
			preparedStatement.setString(4, user.getPass_word());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public user selectUser(String User_id) {
		user user = null;
		UserDAO dao = new UserDAO();
		try (Connection connection = dao.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setString(1, User_id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new user();
				user.setUser_id(User_id);
				user.setUser_name(resultSet.getString("uname"));
				user.setEmail_id(resultSet.getString("email"));
				user.setPass_word(resultSet.getString("pass_word"));
				user.setAge(resultSet.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<user> selectAllUsers() {
		List<user> users = new ArrayList<user>();
		UserDAO dao = new UserDAO();
		try (Connection connection = dao.getConnection()) {
			PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				String user_id = resultSet.getString("User_id");
				String user_name = resultSet.getString("uname");
				String email_id = resultSet.getString("email");
				String password = resultSet.getString("Password");
				int age = resultSet.getInt("age");

				users.add(new user(user_id, user_name, email_id, password, age));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

	public boolean deleteUser(int id) {
		boolean status = false;
		UserDAO dao = new UserDAO();

		try (Connection connection = dao.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
			preparedStatement.setInt(1, id);

			status = preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
}
