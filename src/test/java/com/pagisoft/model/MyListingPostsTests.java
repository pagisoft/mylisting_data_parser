package com.pagisoft.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MyListingPostsTests {

    private static final Logger LOGGER = LogManager.getLogger(MyListingPostsTests.class);

    private static final String VALID_LISTING_NAME = "Uczniowski Klub Sportowy Rod\u0142o Opole";
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    @Test
    public void setPostNameTest() {

    }

    @Test
    public void setPostDateGmtTest() {
        LOGGER.info("Executing setPostDateGmtTest().");
        Instant currentInstant = Instant.now();
        MyListingPost newListingPost = new MyListingPost();
        newListingPost.setPostDateGmt(currentInstant);

        Assert.assertEquals(currentInstant.atZone(ZoneId.of("GMT")), newListingPost.getPostDateGmt());

    }

    @Test
    public void getPostDateGmtFormattedTest() {
        LOGGER.info("Executing gettPostDateGmtFormattedTest().");
        Instant currentInstant = Instant.now();
        MyListingPost newListingPost = new MyListingPost();
        newListingPost.setPostDateGmt(currentInstant);

        Assert.assertEquals(currentInstant.atZone(ZoneId.of("GMT")).format(formatter), newListingPost.getPostDateGmtFormatted());
    }
}
