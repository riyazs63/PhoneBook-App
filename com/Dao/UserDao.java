package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Contact;
import com.model.User;

public class UserDao {

	

	private static String url ="jdbc:mysql://localhost:3306/java";
	private static String user ="root";
	private static String password ="riyaz";
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static String insert ="insert into user(name,email,password)values(?,?,?)"; 
	private static String loginUser = "select * from user where email=? and password=?";
	private static String saveContact = "insert into contact(name,email,phno,about,userid)values(?,?,?,?,?)";
	private static String displayContact = "select * from contact where userid=?";
	private static String deleteContact = "delete from contact where id=?";
	private static String editContact = "select * from contact where id=?";
	private static String updateContact = "update contact set name=?,email=?,phno=?,about=? where id=? ";

	

	
	public static boolean userRegister(User u)
	{
		boolean f = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		    ps = con.prepareStatement(insert);
			ps.setString(1,u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return f;
		
	}
	
	// User Login 
	public static User loginUser(User u)
	{
		User u1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(loginUser);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				u1 = new User(id, name, email, password);
			}


		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u1;

	}

	// save contact
	public static boolean saveContact(Contact c)
	{
		boolean f = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(saveContact);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhno());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getUserId());
			int i = ps.executeUpdate();
			
			if(i==1)
			{
				f = true;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return f;
		
	}
	
	// Display data
	public static ArrayList<Contact> displayContact(int uid)
	{
		ArrayList<Contact> al = new ArrayList<Contact>();
		Contact c = null;
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(displayContact);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phoneno = rs.getString("phno");
				String about = rs.getString("about");
				c = new Contact(id, name, email, phoneno, about);
				al.add(c);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
		
		
	}

	// delete contact
	public static void deleteContact(int id)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(deleteContact);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// editConatct details
	
	public static Contact editContact(int id1)
	{
		Contact c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(editContact);
			ps.setInt(1, id1);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String phno = rs.getString("phno");
			String email = rs.getString("email");
			String about = rs.getString("about");
			c = new Contact(id, name, email, phno, about);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return c;
		
	}
	// update contact
	public static boolean updateContact(Contact c)
	{
		boolean f = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(updateContact);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhno());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getId());
			int i = ps.executeUpdate();
			
			if(i==1)
			{
				f = true;
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return f;
	}
	
}
