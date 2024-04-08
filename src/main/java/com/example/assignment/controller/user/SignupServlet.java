package com.example.assignment.controller.user;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.User;
import com.example.assignment.service.UserInf;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    UserInf usRepo = ServiceFactory.getUserSer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/account/signup.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (usRepo.findById(req.getParameter("usname")) != null) {
            req.setAttribute("message", "Tên người dùng tồn tại");
            req.getRequestDispatcher("/view/account/signup.jsp").forward(req, resp);
            return;
        } else if (req.getParameter("usname").isEmpty() || req.getParameter("password").isEmpty()) {
            req.setAttribute("message", "Mật khẩu hoặc tên người dùng trống");
            req.getRequestDispatcher("/view/account/signup.jsp").forward(req, resp);
            return;
        } else {
            User u = new User();
            u.setId(req.getParameter("usname"));
            u.setPassword(req.getParameter("password"));
            u.setFullname(req.getParameter("fullname"));
            u.setEmail(req.getParameter("email"));
            u.setAdmin(req.getParameter("admin") != null);
            usRepo.add(u);
            resp.sendRedirect("login");
        }

    }
}
