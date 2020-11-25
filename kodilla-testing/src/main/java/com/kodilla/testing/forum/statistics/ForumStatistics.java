package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private Statistics statistics;
    private int userNumber;
    private int postNumber;
    private int commentNumber;
    private double postPerUser;
    private double commentPerUser;
    private double commentPerPost;


    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public double getPostPerUser() {
        return postPerUser;
    }

    public void setPostPerUser(double postPerUser) {
        this.postPerUser = postPerUser;
    }

    public double getCommentPerUser() {
        return commentPerUser;
    }

    public void setCommentPerUser(double commentPerUser) {
        this.commentPerUser = commentPerUser;
    }

    public double getCommentPerPost() {
        return commentPerPost;
    }

    public void setCommentPerPost(double commentPerPost) {
        this.commentPerPost = commentPerPost;
    }

    public void calculateAdvStatistics(){
        int userNumber = statistics.userNames().size();
        setUserNumber(userNumber);
        setPostNumber(statistics.postsCount());
        setCommentNumber(statistics.commentsCount());
        setPostPerUser((double) statistics.postsCount()/ userNumber);
        setCommentPerUser((double) statistics.commentsCount()/userNumber);
        setCommentPerPost((double) statistics.commentsCount()/ statistics.postsCount());
    }

    public void showStatistics() {
        System.out.println("Number of users: " + getUserNumber());
        System.out.println("Number of posts: " + getPostNumber());
        System.out.println("Number of comments: " + getCommentNumber());
        System.out.println("Average number of posts per user: " + getPostPerUser());
        System.out.println("Average number of comments per user: " + getCommentPerUser());
        System.out.println("Average number of comments per post: " + getCommentPerPost());

    }
}
