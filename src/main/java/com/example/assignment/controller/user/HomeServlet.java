package com.example.assignment.controller.user;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.Video;
import com.example.assignment.service.UserService;
import com.example.assignment.service.VideoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    VideoService serviceVD = ServiceFactory.getVideoService();
    UserService serviceUS = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Video> movieLst = serviceVD.findAllActive();
        req.setAttribute("items", movieLst);
        req.setAttribute("requestURI", req.getRequestURI());
        String keyword = req.getParameter("keyword");

        if (keyword != null) {
            System.out.println("In home, keyword=" + keyword);
            List<Video> itemsVDSearch = serviceVD.searchActive(keyword);
            req.setAttribute("items", itemsVDSearch);
            req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("items", movieLst);
        req.getRequestDispatcher("/view/home.jsp").forward(req, resp);

    }
}
