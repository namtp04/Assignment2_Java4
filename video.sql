drop table if exists Users;

CREATE TABLE Users(
    id varchar(100) PRIMARY KEY,
    password varchar(100),
    fullname nvarchar(100),
    email nvarchar(100),
    admin bit
);

CREATE TABLE Videos(
    id varchar(100) PRIMARY KEY,
    title nvarchar(200) ,
    poster nvarchar(200),
    description nvarchar(200),
    views int,
    active bit
);

CREATE TABLE Favorites(
    id BIGINT PRIMARY KEY IDENTITY (1, 1),
    userid varchar(100),
    videoid varchar(100),
    likedate DATE,
    FOREIGN KEY (userid) REFERENCES Users(id),
    FOREIGN KEY (videoid) REFERENCES Videos(id)
);

insert into Users values('user1', '1', 'User 1', 'user1@test.com', 0),
('user2', '2', 'User 2', 'user2@test.com', 0),
('user3', '3', 'User 3', 'user3@test.com', 0),
('user4', '4', 'User 4', 'user4@test.com',  0),
('user5', '5', 'User 5', 'user5@test.com', 0);

insert into Videos values('vid1', 'Video 1', '', '', 100, 1),
('vid2', 'Video 2', '', '', 200, 1),
('vid3', 'Video 3', '', '', 300, 1),
('vid4', 'Video 4', '', '', 40, 0),
('vid5', 'Video 5', '', '', 50, 0);

insert into Favorites(userid,videoid,likedate)
values('user1','vid1','2024-03-01'),
('user1','vid2','2024-03-02'),
('user2','vid1','2024-03-01'),
('user2','vid3','2024-03-03'),
('user3','vid1','2024-03-02');