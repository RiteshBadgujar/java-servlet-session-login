// WelcomeServlet.java

package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("User") != null) {

            String username = (String) session.getAttribute("User");

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome</title>");

            out.println("<style>");
            out.println("body{");
            out.println("font-family:Arial;");
            out.println("background:#f4f4f4;");
            out.println("text-align:center;");
            out.println("padding-top:100px;");
            out.println("}");

            out.println(".box{");
            out.println("background:white;");
            out.println("width:400px;");
            out.println("margin:auto;");
            out.println("padding:30px;");
            out.println("border-radius:10px;");
            out.println("box-shadow:0 0 10px gray;");
            out.println("}");

            out.println("a{");
            out.println("display:inline-block;");
            out.println("margin-top:20px;");
            out.println("padding:10px 20px;");
            out.println("background:red;");
            out.println("color:white;");
            out.println("text-decoration:none;");
            out.println("border-radius:5px;");
            out.println("}");
            out.println("</style>");

            out.println("</head>");
            out.println("<body>");

            out.println("<div class='box'>");
            out.println("<h1>Welcome " + username + "</h1>");
            out.println("<p>Login Successful</p>");
            out.println("<a href='logout'>Logout</a>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");

        } else {
            response.sendRedirect("SessionLogin.html");
        }
    }
}