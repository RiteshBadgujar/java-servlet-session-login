// LoginServlet.java

package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "1234".equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("User", username);

            response.sendRedirect("welcome");

        } else {

            out.println("<h2 style='color:red;text-align:center;'>Invalid Username or Password</h2>");
            out.println("<div style='text-align:center;'>");
            out.println("<a href='SessionLogin.html'>Try Again</a>");
            out.println("</div>");
        }
    }
}