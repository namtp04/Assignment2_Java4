package com.example.assignment.controller.user;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.Favorite;
import com.example.assignment.entity.User;
import com.example.assignment.entity.Video;
import com.example.assignment.service.FavoriteInf;
import com.example.assignment.service.VideoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet({
        "/detail",
        "/delete"
})
public class DetailServlet extends HttpServlet {
    VideoService service = ServiceFactory.getVideoService();
    FavoriteInf serFV = ServiceFactory.getFavoriteSer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/delete")) {
            deleteFV(req,resp);
            return;
        }
        String id = req.getParameter("id");
        String username = (String) req.getSession().getAttribute("username");

        Video video = service.findById(id);
        Favorite fv = serFV.findByVideoId(id, username);
        req.setAttribute("fv", fv);
        req.setAttribute("fvn", fv);
        req.setAttribute("usn1", username);
        req.setAttribute("video", video);
        req.getRequestDispatcher("/view/detail.jsp").forward(req, resp);

    }

    protected void themFV(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Favorite fv = new Favorite();
        String id = req.getParameter("id");
        User u = new User();
        u.setId((String) req.getSession().getAttribute("username"));
        Video vd = new Video();
        vd.setId(id);
        fv.setUser(u);
        fv.setVideo(vd);
        Date d = new Date();
        fv.setLikedate(d);
        serFV.add(fv);
        resp.sendRedirect("detail?id=" +id);
    }

    protected void deleteFV(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idx = Long.parseLong(req.getParameter("idx"));
        Favorite fv = serFV.findById(idx);
        String id = fv.getVideo().getId();
        serFV.delete(fv);
        resp.sendRedirect("detail?id=" + id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        themFV(req, resp);

    }
}
