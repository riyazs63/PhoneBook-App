package com.Servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.model.Contact;
import com.model.User;


@WebServlet("/")
public class RegisterS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();
		switch(path)
		{
		case "/update":updateContact(request,response);
		break;
		case "/delete":deleteUser(request,response);
		break;
		case "/addcontact":addContact(request,response);
		break;
		case "/logout" :logoutUser(request,response);
		break;
		case "/login":loginUser(request,response);
		break;
		case "/register":registerUser(request,response);
		break;
		default:index(request,response);
		break;
		}
		
	}


	private void updateContact(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt (request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneno = request.getParameter("phoneno");
		String about = request.getParameter("about");
		Contact c = new Contact(id, name, email, phoneno, about);
		
		HttpSession session = request.getSession();
		
		boolean f = UserDao.updateContact(c);
		if(f)
		{
			session.setAttribute("successMsg", "Your Contact updated Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("viewContact.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
		else 
		{
			session.setAttribute("failedMsg", "Something Wrong on server");
			RequestDispatcher rd = request.getRequestDispatcher("editcontact.jsp?cid="+id);
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}




	




	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt (request.getParameter("id"));
		UserDao.deleteContact(id);
		try {
			response.sendRedirect("viewContact.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private void addContact(HttpServletRequest request, HttpServletResponse response) {
		int userId = Integer.parseInt(request.getParameter("userid"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneno = request.getParameter("phoneno");
		String about = request.getParameter("about");
		Contact c = new Contact(name, email, phoneno, about, userId);
		boolean f = UserDao.saveContact(c);
		HttpSession session = request.getSession();
		if(f)
		{
			session.setAttribute("successMsg", "Your Contact Saved Successfully");
			try {
				response.sendRedirect("addContact.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else 
		{
			session.setAttribute("failedMsg", "Something Wrong on server");
			try {
				response.sendRedirect("addContact.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}



		
	}


	private void logoutUser(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		HttpSession session2 = request.getSession();
		session2.setAttribute("logoutmsg", "Logout Sucessfully...");
		try {
			response.sendRedirect("login.jsp");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}


	private void loginUser(HttpServletRequest request, HttpServletResponse response) {
	
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User u = new User(email, password);
		User u1 = UserDao.loginUser(u);
		HttpSession session = request.getSession();
		if(u1 !=null)
		{
			session.setAttribute("user", u1);
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			session.setAttribute("invalidMsg", "Invalid Email & Password");
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


	private void registerUser(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User u = new User(name, email, password);
		HttpSession session = request.getSession();
		boolean f = UserDao.userRegister(u);
		if(f==true)
		{
			session.setAttribute("SuccessMsg", "User Register Successfully");
			try {
				response.sendRedirect("Register.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			session.setAttribute("ErrorMsg", "Something Went Wrong on Server");
			try {
				response.sendRedirect("Register.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}


		}

	}


	private void index(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
