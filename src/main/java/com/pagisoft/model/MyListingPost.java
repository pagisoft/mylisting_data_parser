package com.pagisoft.model;

import com.pagisoft.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MyListingPost {

    private static final Logger LOGGER = LogManager.getLogger(MyListingPost.class);

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    private static final String GUID_LINK_PREFIX = "https://nudyzbudy.pl/listing/";
    //Fri Nov 15 12:03:25 CET 2019

    // wp_posts table fields
    // some of the fields are final static, initialized with values
    //private int id;
    private final static Integer postAuthor = 1;
    private ZonedDateTime postDate;
    private ZonedDateTime postDateGmt;
    private final static String postContent = "";
    private String postTitle;
    private final static String postExcerpt = "";
    private final static String postStatus = "publish";
    private final static String commentStatus = "open";
    private final static String pingStatus = "open";
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

    // get value in the right string format
    public String getPostDateFormatted() {
        return postDate.format(formatter);
    }

    protected void setPostDate(Instant currentInstant) {
        this.postDate = currentInstant.atZone(ZoneId.of("Europe/Warsaw"));;
    }

    public ZonedDateTime getPostDateGmt() {
        return postDateGmt;
    }

    // get value in the right string format
    public String getPostDateGmtFormatted() {
        return postDateGmt.format(formatter);
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
        postName = postName.toLowerCase();
        postName = Utils.removePolishCharacters(postName);
        postName = Utils.replaceSpacesWithDashes(postName);

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

    // get value in the right string format
    public String getPostModifiedFormatted() {
        return postModified.format(formatter);
    }

    protected void setPostModified(Instant currentInstant) {
        this.postModified = currentInstant.atZone(ZoneId.of("Europe/Warsaw"));
    }

    public ZonedDateTime getPostModifiedGmt() {
        return postModifiedGmt;
    }

    // get value in the right string format
    public String getPostModifiedGmtFormatted() {
        return postModifiedGmt.format(formatter);
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
        guid = guid.toLowerCase();
        guid = Utils.removePolishCharacters(guid);
        guid = Utils.replaceSpacesWithDashes(guid);
        this.guid = GUID_LINK_PREFIX + guid + "/";
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