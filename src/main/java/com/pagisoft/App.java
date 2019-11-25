package com.pagisoft;

import com.pagisoft.model.MyListingPost;
import com.pagisoft.service.CourseDataReader;
import com.pagisoft.service.CourseDataWriter;

import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        Set<MyListingPost> elementsCollection = new CourseDataReader().readInputData();
        new CourseDataWriter().prepareSqlInsertStatement(elementsCollection);
    }
}
