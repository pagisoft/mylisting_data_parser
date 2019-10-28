package com.pagisoft.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class CourseDataReader implements InputDataReader {

    private static final Logger LOGGER = LogManager.getLogger(CourseDataReader.class);

    @Override
    public void readInputData() {

        ObjectMapper mapper = new ObjectMapper();

        try (FileReader courseDataReader = new FileReader("D:\\Projekty\\mylisting_data_parser\\test_data\\opole.json")) {

            JsonNode rootNode = mapper.readTree(courseDataReader);
            JsonNode payloadNode = rootNode.path("payload");

            System.out.println("here");

            Iterator<JsonNode> clubIterator = payloadNode.elements();
            while (clubIterator.hasNext()) {
                JsonNode temp = clubIterator.next().path("club");
                LOGGER.info(temp.path("name"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
