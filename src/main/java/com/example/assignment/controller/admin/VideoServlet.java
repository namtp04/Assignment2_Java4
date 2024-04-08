package com.example.assignment.controller.admin;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({
        "/movie/list",
        "/movie/add",
        "/movie/update",
        "/movie/delete",
})
public class VideoServlet extends HttpServlet {
    VideoService mvRepo = ServiceFactory.getVideoService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Video> lstMovie = mvRepo.findAll();
        System.out.println("List size: " + lstMovie.size());
        req.setAttribute("lstMovie", lstMovie);
        String uri = req.getRequestURI();
        if(uri.contains("/list")){
            req.getRequestDispatcher("/view/admin/video_list.jsp").forward(req, resp);
        }
        if(uri.contains("/add")){
            req.getRequestDispatcher("/view/admin/video_form.jsp").forward(req,resp);
        }
        if(uri.contains("/delete")){
            delete(req,resp);
            return;
        }
        if(uri.contains("/update")){
            String id = req.getParameter("id");
            req.setAttribute("movie1", mvRepo.findById(id));
            req.getRequestDispatcher("/view/admin/video_form.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/add")){
            create(req,resp);
        }
        if(uri.contains("/update")){
            update(req,resp);
        }

    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Video us = new Video();
        us.setId(req.getParameter("id"));
        us.setTitle(req.getParameter("title"));
        us.setDescription(req.getParameter("mota"));
        us.setPoster(req.getParameter("image"));
        us.setActive(req.getParameter("active") != null);
        mvRepo.add(us);
        resp.sendRedirect("../movie/list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Video vd = mvRepo.findById(req.getParameter("id"));
        mvRepo.deleteById(vd);
        resp.sendRedirect("../movie/list");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Video us = new Video();
        us.setId(req.getParameter("id"));
        us.setTitle(req.getParameter("title"));
        us.setDescription(req.getParameter("mota"));
        us.setPoster(req.getParameter("image"));
        us.setActive(req.getParameter("active") != null);
        mvRepo.update(us);
        resp.sendRedirect("../movie/list");
    }
}
