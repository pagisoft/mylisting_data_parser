package com.pagisoft;

import com.pagisoft.service.CourseDataReader;
import com.pagisoft.service.CourseDataWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //new CourseDataReader().readInputData();
        new CourseDataWriter().prepareSqlInsertStatement();
    }
}
