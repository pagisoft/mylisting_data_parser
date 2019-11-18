package com.pagisoft.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class MyListingPost {

    private static final Logger LOGGER = LogManager.getLogger(MyListingPost.class);

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    //Fri Nov 15 12:03:25 CET 2019

    // wp_posts table fields
    // some of the fields are final static, initialized with values
    //private int id;
    private final static Integer postAuthor = 27;
    private ZonedDateTime postDate;
    private ZonedDateTime postDateGmt;
    private final static String postContent = "";
    private String postTitle;
    private final static String postExcerpt = "";
    private final static String postStatus = "publish";
    private final static String commentStatus = "open";
    private final static String pingStatus = "closed";
    private final static String postPassword = "";
    private String postName;
    private final static String toPing = "";
    private final static String pinged = "";
    private ZonedDateTime postModified;
    private ZonedDateTime postModifiedGmt;
    private final static String postContentFiltered = "";
    private final static Integer postParent = 0;
    private String guid;
    private final static Integer menuOrder = 0;
    private final static String postType = "job_listing";
    private final static String postMimeType = "";
    private final static Integer commentCount = 0;

    protected MyListingPost() {};

    public MyListingPost(String listingName) {
        Instant currentInstant = Instant.now();

        setPostDate(currentInstant);
        setPostDateGmt(currentInstant);
        setPostTitle(listingName);
        setPostName(listingName);
        setPostModified(currentInstant);
        setPostModifiedGmt(currentInstant);
        setGuid(listingName);
    }

    public Integer getPostAuthor() {
        return postAuthor;
    }

    public ZonedDateTime getPostDate() {
        return postDate;
    }

    protected void setPostDate(Instant currentInstant) {
        this.postDate = currentInstant.atZone(ZoneId.of("Europe/Warsaw"));;
    }

    public ZonedDateTime getPostDateGmt() {
        return postDateGmt;
    }

    protected void setPostDateGmt(Instant currentInstant) {
        this.postDateGmt = currentInstant.atZone(ZoneId.of("GMT"));
    }

    public String getPostContent() {
        return postContent;
    }

    public String getPostTitle() {
        return postTitle;
    }

    private void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public String getPingStatus() {
        return pingStatus;
    }

    public String getPostPassword() {
        return postPassword;
    }

    public String getPostName() {
        return postName;
    }

    protected void setPostName(String postName) {
        this.postName = postName;
    }

    public String getToPing() {
        return toPing;
    }

    public String getPinged() {
        return pinged;
    }

    public ZonedDateTime getPostModified() {
        return postModified;
    }

    protected void setPostModified(Instant currentInstant) {
        this.postModified = currentInstant.atZone(ZoneId.of("Europe/Warsaw"));
    }

    public ZonedDateTime getPostModifiedGmt() {
        return postModifiedGmt;
    }

    protected void setPostModifiedGmt(Instant currentInstant) {
        this.postModifiedGmt = currentInstant.atZone(ZoneId.of("GMT"));
    }

    public String getPostContentFiltered() {
        return postContentFiltered;
    }

    public Integer getPostParent() {
        return postParent;
    }

    public String getGuid() {
        return guid;
    }

    protected void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public String getPostType() {
        return postType;
    }

    public String getPostMimeType() {
        return postMimeType;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

}