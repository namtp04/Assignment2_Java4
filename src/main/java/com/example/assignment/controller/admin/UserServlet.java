package com.example.assignment.controller.admin;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.User;
import com.example.assignment.entity.Video;
import com.example.assignment.service.UserInf;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({
        "/user/view",
        "/user/update",
        "/user/delete"
})
public class UserServlet extends HttpServlet {
    UserInf ser = ServiceFactory.getUserSer();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> lst = ser.findAll();

        String uri = req.getRequestURI();
        if (uri.contains("/update")) {
            String id = req.getParameter("id");
            req.setAttribute("user1", ser.findById(id));
        }
        if(uri.contains("/delete")){
            delete(req,resp);
            return;
        }

        System.out.println("List size: " + lst.size());
        req.setAttribute("lst", lst);
        req.getRequestDispatcher("/view/admin/user_view.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        User vd = ser.findById(req.getParameter("id"));
        ser.delete(vd);
        resp.sendRedirect("/assignment2_war_exploded/user/view");
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User us = new User();
        us.setId(req.getParameter("id"));
        us.setPassword(req.getParameter("password"));
        us.setEmail(req.getParameter("email"));
        us.setFullname(req.getParameter("fullname"));
        us.setAdmin(req.getParameter("admin") != null);
        ser.add(us);
        resp.sendRedirect("/assignment2_war_exploded/user/view");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User us = new User();
        us.setId(ser.findById(req.getParameter("id")).getId());
        us.setPassword(ser.findById(req.getParameter("id")).getPassword());
        us.setEmail(req.getParameter("email"));
        us.setFullname(req.getParameter("fullname"));
        us.setAdmin(req.getParameter("admin") != null);
        ser.update(us);
        resp.sendRedirect("/assignment2_war_exploded/user/view");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/update")) {
            update(req, resp);
        } else {
            create(req, resp);
        }

    }
}
