package com.example.assignment.controller.user;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.Favorite;
import com.example.assignment.entity.Video;
import com.example.assignment.service.FavoriteInf;
import com.example.assignment.service.VideoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/favorite")
public class FavoriteServlet extends HttpServlet {
    VideoService service = ServiceFactory.getVideoService();
    FavoriteInf ser = ServiceFactory.getFavoriteSer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("requestURI", req.getRequestURI());
        String username = (String) req.getSession().getAttribute("username");
        if (username == null) {
            resp.sendRedirect("login");
            return;
        }
        String keyword = req.getParameter("keyword");
        if (keyword != null) {
            System.out.println("In favorite, keyword=" + keyword);
            List<Favorite> itemFV = ser.searchActive(keyword, username);
            req.setAttribute("itemsFV", itemFV);
            req.getRequestDispatcher("/view/favorite.jsp").forward(req, resp);
            return;
        }


        List<Favorite> items = ser.findAll(username);
        req.setAttribute("itemsFV", items);
        req.getRequestDispatcher("/view/favorite.jsp").forward(req, resp);
    }
}
