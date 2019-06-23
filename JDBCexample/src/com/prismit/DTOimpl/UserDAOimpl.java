package com.prismit.DTOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.prismit.DAO.IuserDAO;
import com.prismit.DTO.UserDTO;

public class UserDAOimpl implements IuserDAO {

	Connection connect;
	
	List<UserDTO> users = new ArrayList<>();
	private Statement statement;

	@Override
	public List<UserDTO> findAll() throws SQLException, Exception {
		// TODO Auto-generated method stub
		System.out.println(users.toString());
		System.out.println("exec in findall method");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports", "root", "root");

			statement = connect.createStatement();
			ResultSet rs = statement.executeQuery("select * from students");
			System.out.println("in try block");
			while (rs.next()) {

				String std_winner = rs.getString("std_winner");
				String std_name = rs.getString("std_name");
				String address = rs.getString("address");
				String email_id = rs.getString("email_id");
				String school = rs.getString("school");
				System.out.println("getString");

				UserDTO user = new UserDTO();
				user.setStd_winner(std_winner);
				user.setStd_name(std_name);
				user.setAddress(address);
				user.setEmail_id(email_id);
				user.setSchool(school);
				users.add(user);
				System.out.println("userdto");
			}

		} catch (Exception e) {
			System.out.println("in catch block");
			throw e;
		} finally {
			connect.close();

		}
		return users;
	}

	@Override
	public void create(UserDTO userDTO ) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(userDTO.toString());
		String std_winner=userDTO.getStd_winner();
		String std_name=userDTO.getStd_name();
		String address=userDTO.getAddress();
		String email_id=userDTO.getEmail_id();
		String school = userDTO.getSchool();
		      try {
		           // This will load the MySQL driver, each DB has its own driver
		           Class.forName("com.mysql.cj.jdbc.Driver");
		           // Setup the connection with the DB
		           connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports", "root", "root");


		           // PreparedStatements can use variables and are more efficient
		           PreparedStatement preparedStatement = connect
		                   .prepareStatement("insert into  students values (?, ?, ?, ?, ?)");
		           // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
		           // Parameters start with 1
		           preparedStatement.setString(1, std_winner);
		           preparedStatement.setString(2, std_name);
		           preparedStatement.setString(3, address);
		           preparedStatement.setString(4, email_id);
				   preparedStatement.setString(5, school);
		           preparedStatement.executeUpdate();


		}

		     catch (Exception e) {
		        throw e;
		    } finally {
		        connect.close();
		    }
		      
	}

	@Override
	public void update(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		
	      try {
	           // This will load the MySQL driver, each DB has its own driver
	           Class.forName("com.mysql.cj.jdbc.Driver");
	           // Setup the connection with the DB
	           connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports", "root", "root");

	           String address=userDTO.getAddress();
	           String std_winner=userDTO.getStd_winner();
	           
	           // PreparedStatements can use variables and are more efficient
	           PreparedStatement preparedStatement = connect
	                   .prepareStatement("update students set address =? where std_winner = ?");
	
			preparedStatement.setString(1, address);
	           preparedStatement.setString(2, std_winner);
	           preparedStatement.executeUpdate();
	          
	      }

		     catch (Exception e) {
		        throw e;
		    } finally {
		        connect.close();
		    }
		
		
	
	}}


	/*@Override
	public void update(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}
/*
	@Override
	public void create(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(user.toString());
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports","root","root");
		
			   PreparedStatement = connect
	                   .prepareStatement("insert into  test_db.users values (?, ?, ?, ? )");
	           // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
	           // Parameters start with 1
	           PreparedStatement.setString(1,id);
	           PreparedStatement.setString(2, firstName);
	           PreparedStatement.setString(3, lastName);
	           PreparedStatement.setString(4,age);
	           PreparedStatement.executeUpdate();	}

	@Override
	public void update(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

}*/
