package com.sda.servlet;

import com.sda.model.User;
import com.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            User user = userService.login(request.getParameter("un"), request.getParameter("pw"));

            if (user != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                Cookie userName = new Cookie("user", user.getUsername());
                userName.setMaxAge(30*60);
                response.addCookie(userName);
                response.sendRedirect("home.jsp"); //logged-in page
            } else
                response.sendRedirect("invalidLogin.jsp"); //error page
        } catch (Throwable ex) {
            System.out.println(ex);
        }
    }
}