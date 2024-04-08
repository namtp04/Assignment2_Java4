package com.example.assignment.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Favorites", uniqueConstraints={
        @UniqueConstraint(columnNames = {"VideoId" , "UserId"})
})
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne @JoinColumn(name = "userid")
    User user;

    @ManyToOne @JoinColumn(name = "videoid")
    Video video;

    @Temporal(TemporalType.DATE)
    Date likedate = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getLikedate() {
        return likedate;
    }

    public void setLikedate(Date likedate) {
        this.likedate = likedate;
    }
}
