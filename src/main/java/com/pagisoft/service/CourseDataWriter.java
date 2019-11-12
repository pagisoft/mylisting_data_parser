package com.pagisoft.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Date;

public class CourseDataWriter {

    private static final Logger LOGGER = LogManager.getLogger(CourseDataWriter.class);

    public void prepareSqlInsertStatement() {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();


        //context.put("date", getMyTimestampFunction());
        //Template t = ve.getTemplate( "templates/email_html_new.vm" );
        //StringWriter writer = new StringWriter();
        //t.merge( context, writer );

        Template insertListingTemplate = velocityEngine.getTemplate("templates/insert_listing_template.sql");

        VelocityContext context = new VelocityContext();
        context.put("post_date", new Date());
        //dodać kolejne pola do sql

        StringWriter writer = new StringWriter();
        insertListingTemplate.merge(context, writer);

        LOGGER.info(writer.toString());

        LOGGER.info("done");




    }
}
