package com.onine.logger;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/*
 * @author: Bhushan Ladde
 */

public class Log {

public  Log() 
{
    Properties props = new Properties();
    try {
        props.load(getClass().getResourceAsStream("/log4j.properties"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    PropertyConfigurator.configure(props);
}

public  Logger getLogger(Class<?> className) 
{
    Logger logger = Logger.getLogger(className);
    return logger;
}
/*public static void main(String[] args) {
	System.out.println(new  Log().getLogger(Log.class));
}*/
}