package com.pagisoft.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pagisoft.model.MyListingPost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CourseDataReader implements InputDataReader {

    private static final Logger LOGGER = LogManager.getLogger(CourseDataReader.class);

    @Override
    public Set<MyListingPost> readInputData() {

        Set<MyListingPost> elementsCollection = new HashSet<>();

        ObjectMapper mapper = new ObjectMapper();

        //try (FileReader courseDataReader = new FileReader("D:\\Projekty\\mylisting_data_parser\\test_data\\opole.json")) {
        try (FileReader courseDataReader = new FileReader("D:\\Projekty\\mylisting_data_parser\\test_data\\opole/pilka_nozna.json")) {

            JsonNode rootNode = mapper.readTree(courseDataReader);
            JsonNode payloadNode = rootNode.path("payload");

            System.out.println("here");

            Iterator<JsonNode> clubIterator = payloadNode.elements();
            while (clubIterator.hasNext()) {
                JsonNode temp = clubIterator.next().path("club");
                elementsCollection.add(
                        new MyListingPost(temp.path("name").toString())
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return elementsCollection;
    }
}
