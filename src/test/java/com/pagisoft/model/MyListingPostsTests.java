package com.pagisoft.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class MyListingPostsTests {

    private static final Logger LOGGER = LogManager.getLogger(MyListingPostsTests.class);

    private static final String VALID_LISTING_NAME = "Uczniowski Klub Sportowy Rod\u0142o Opole";
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final String VALID_GUID_LINK = "https://nudyzbudy.pl/listing/uczniowski-klub-sportowy-rodlo-opole/";

    @Test
    public void setPostDateGmtTest() {
        LOGGER.info("Executing setPostDateGmtTest().");
        Instant currentInstant = Instant.now();
        MyListingPost newListingPost = new MyListingPost();
        newListingPost.setPostDateGmt(currentInstant);

        LOGGER.info(currentInstant);
        LOGGER.info(currentInstant.atZone(ZoneId.of("GMT")));
        LOGGER.info(newListingPost.getPostDateGmt());

        Assert.assertEquals(currentInstant.atZone(ZoneId.of("GMT")), newListingPost.getPostDateGmt());

    }

    @Test
    public void getPostDateGmtFormattedTest() {
        LOGGER.info("Executing getPostDateGmtFormattedTest().");
        Instant currentInstant = Instant.now();
        MyListingPost newListingPost = new MyListingPost();
        newListingPost.setPostDateGmt(currentInstant);

        LOGGER.info(currentInstant);
        LOGGER.info(currentInstant.atZone(ZoneId.of("GMT")).format(formatter));
        LOGGER.info(newListingPost.getPostDateGmtFormatted());

        Assert.assertEquals(currentInstant.atZone(ZoneId.of("GMT")).format(formatter), newListingPost.getPostDateGmtFormatted());
    }

    @Test
    public void getPostName() {
        LOGGER.info("Executing getPostName().");

        String expectedPostName = "uczniowski-klub-sportowy-rodlo-opole";

        MyListingPost newListingPost = new MyListingPost();
        newListingPost.setPostName(VALID_LISTING_NAME);

        LOGGER.info(VALID_LISTING_NAME);
        LOGGER.info(expectedPostName);
        LOGGER.info(newListingPost.getPostName());

        Assert.assertEquals(expectedPostName, newListingPost.getPostName());

    }

    @Test
    public void getPostNamePolishCharacters() {
        LOGGER.info("Executing getPostNamePolishCharacters().");

        String originalPostName = "  Ą    ŚĆŻŹ Ę ę e ĘĄ ÓóóÓ łłłł    Ł AAĄĄĄAćńŃŃ śśś         ";
        String expectedPostName = "a-sczz-e-e-e-ea-oooo-llll-l-aaaaaacnnn-sss";

        MyListingPost newListingPost = new MyListingPost();
        newListingPost.setPostName(originalPostName);

        LOGGER.info(originalPostName);
        LOGGER.info(expectedPostName);
        LOGGER.info(newListingPost.getPostName());

        Assert.assertEquals(expectedPostName, newListingPost.getPostName());

    }

    @Test
    public void getGuidTest() {
        LOGGER.info("Executing getGuidTest().");

        MyListingPost newListingPost = new MyListingPost();
        newListingPost.setGuid(VALID_LISTING_NAME);

        LOGGER.info(VALID_LISTING_NAME);
        LOGGER.info(VALID_GUID_LINK);
        LOGGER.info(newListingPost.getGuid());

        Assert.assertEquals(VALID_GUID_LINK, newListingPost.getGuid());
    }
}
