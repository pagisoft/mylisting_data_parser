package com.pagisoft.service;

import com.pagisoft.model.MyListingPost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Date;
import java.util.Set;

public class CourseDataWriter {

    private static final Logger LOGGER = LogManager.getLogger(CourseDataWriter.class);

    public void prepareSqlInsertStatement(Set<MyListingPost> elementsCollection) {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();


        //context.put("date", getMyTimestampFunction());
        //Template t = ve.getTemplate( "templates/email_html_new.vm" );
        //StringWriter writer = new StringWriter();
        //t.merge( context, writer );

        MyListingPost post = elementsCollection.iterator().next();

        Template insertListingTemplate = velocityEngine.getTemplate("templates/insert_listing_template.sql");

        VelocityContext context = new VelocityContext();
        context.put("post_author", post.getPostAuthor());
        context.put("post_date", post.getPostDateFormatted());
        context.put("post_date_gmt", post.getPostDateGmtFormatted());
        context.put("post_content", post.getPostContent());
        context.put("post_title", post.getPostTitle());
        context.put("post_excerpt", post.getPostExcerpt());
        context.put("post_status", post.getPostStatus());
        context.put("comment_status", post.getCommentStatus());
        context.put("ping_status", post.getPingStatus());
        context.put("post_password", post.getPostPassword());
        context.put("post_name", post.getPostName());
        context.put("to_ping", post.getToPing());
        context.put("pinged", post.getPinged());
        context.put("post_modified", post.getPostModifiedFormatted());
        context.put("post_modified_gmt", post.getPostModifiedGmtFormatted());
        context.put("post_content_filtered", post.getPostContentFiltered());
        context.put("post_parent", post.getPostParent());
        context.put("guid", post.getGuid());
        context.put("menu_order", post.getMenuOrder());
        context.put("post_type", post.getPostType());
        context.put("post_mime_type", post.getPostMimeType());
        context.put("comment_count", post.getCommentCount());

        StringWriter writer = new StringWriter();
        insertListingTemplate.merge(context, writer);

        LOGGER.info(writer.toString());

        LOGGER.info("done");




    }
}
