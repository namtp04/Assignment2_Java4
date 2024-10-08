package com.example.assignment.controller.user;

import com.example.assignment.ServiceFactory;
import com.example.assignment.service.UserInf;
import com.example.assignment.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService service = ServiceFactory.getUserService();
    UserInf usRepo = ServiceFactory.getUserSer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/account/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("usname");
        String passWord = req.getParameter("password");
        if (service.checkUser(userName, passWord)) {
            req.getSession().setAttribute("username", userName);
            if (usRepo.findByAdmin(userName) == null) {
                resp.sendRedirect("home");
            } else {
                resp.sendRedirect("/assignment2_war_exploded/movie/list");
            }

            return;
        }
        req.setAttribute("message", "Incorrect username/password");
        req.getRequestDispatcher("/view/account/login.jsp").forward(req, resp);
    }
}
