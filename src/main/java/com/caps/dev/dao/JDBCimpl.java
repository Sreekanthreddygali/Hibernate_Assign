package com.caps.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.caps.dev.beans.Person;
import com.mysql.jdbc.Driver;

public class JDBCimpl implements DAOimpl {

	public  void Create(Person person) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");//Step-1

			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";
			con = DriverManager.getConnection(dbUrl,"root","root"); //Step-2

			String sql = "insert into person_info values(?,?,?,?,?)";//Step-3
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, person.getId());
			pstmt.setString(2,person.getName());
			pstmt.setInt(3, person.getAge());
			pstmt.setString(4, person.getEmailId());
			pstmt.setString(5, person.getAddress());
			int count = pstmt.executeUpdate();

			if(count > 0) {
				System.out.println("Person data is stored successfully..");//Step-4
			}else {
				System.out.println("Failed!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {							//Step-5
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public  void Delete(Person person) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");					//Step-1

			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";
			con = DriverManager.getConnection(dbUrl,"root","root"); //Step-2
			//System.out.println("Connected...");

			String sql = "delete from person_info where id=?";		//Step-3
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, person.getId());
			int count = pstmt.executeUpdate();

			if(count > 0) {
				System.out.println("Person Data has Deleted");	//Step-4
			}else {
				System.out.println("Failed..!!!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {								//Step-5
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public  void Search(Person person) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");//Step-1

			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db"
					+ "?user=root&password=root";
			con = DriverManager.getConnection(dbUrl); //Step-2


			String sql = "select * from person_info where id=? ";//Step-3
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, person.getId());
			rs = pstmt.executeQuery();

			while(rs.next()){								//Step-4
				System.out.println("Id : "+rs.getInt("id"));
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("Age : "+rs.getInt("age"));
				System.out.println("EmailId : "+rs.getString("email_id"));
				System.out.println("Address : "+rs.getString("address"));
				System.out.println("*********************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {							//Step-5
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end of main

	public  void Update(Person person) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//Step-1

			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";
			con = DriverManager.getConnection(dbUrl,"root","root"); //Step-2

			String sql = "update person_info set email_id=? where id=?";		//Step-3
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, person.getEmailId());
			pstmt.setInt(2, person.getId());
			int count = pstmt.executeUpdate();

			if(count > 0) {												//Step-4
				System.out.println("Person Data has Updated");
			}else {
				System.out.println("Failed..!!!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {								//Step-5
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

