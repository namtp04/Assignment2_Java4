package com.example.assignment;

import com.example.assignment.service.FavoriteInf;
import com.example.assignment.service.UserInf;
import com.example.assignment.service.UserService;
import com.example.assignment.service.VideoService;
import com.example.assignment.service.impl.FavoriteSer;
import com.example.assignment.service.impl.UserSer;
import com.example.assignment.service.impl.UserServiceMockImpl;
import com.example.assignment.service.impl.VideoServiceMockImpl;

public class ServiceFactory {
    static VideoService videoService = new VideoServiceMockImpl();
    static UserService userService = new UserServiceMockImpl();
    static FavoriteInf favoriteSer = new FavoriteSer();
    static UserInf userSer = new UserSer();

    public static VideoService getVideoService() {
        return videoService;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static FavoriteInf getFavoriteSer() {
        return favoriteSer;
    }

    public static UserInf getUserSer() {
        return userSer;
    }
}
