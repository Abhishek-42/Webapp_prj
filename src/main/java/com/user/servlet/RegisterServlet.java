package com.user.servlet;

import com.user.dao.UserDAO;
import com.user.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle POST request for registration
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("user_name");
    	String email = request.getParameter("email_id");
    	String password = request.getParameter("pass_word");
    	int age = Integer.parseInt(request.getParameter("age"));


        User newUser = new User();
        newUser.setUserName(username);
        newUser.setEmailId(email);
        newUser.setPassWord(password);
        newUser.setAge(age);

        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.insertUser(newUser);

        // Redirect to success page if registration is successful
        if (success) {
            response.sendRedirect("success.jsp");
        } else {
            // Optionally, you can redirect to an error page
            response.sendRedirect("error.jsp");
        }
    }
}
