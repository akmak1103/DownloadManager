package com.ncu.validators;
import java.io.*;
import java.util.*;
import com.ncu.exceptions.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class PathValidator
{
    public static boolean checkPath(String path)
    {
    	Properties prop = new Properties();
        FileInputStream input = null;
        Logger logger = Logger.getLogger(PathValidator.class);
        PropertyConfigurator.configure("C:\\Users\\Akshay\\Desktop\\DownloadManager\\configs\\logger\\logger.properties");
        try
        {
            input = new FileInputStream("C:\\Users\\Akshay\\Desktop\\DownloadManager\\configs\\constants\\exceptions.properties");
            prop.load(input);
            pathExist(path);
        }    
        catch (PathInvalidException e)
        {
         	logger.error("\n"+e+(prop.getProperty("pathInvalidMessage"))+"\n");
          	return false;
        }
        
        catch (Exception e)     
        {
            logger.error("\n"+e.getMessage()+"\n");
            return false;
        }
        return true;
    }
    
    public static void pathExist(String srcpath) throws PathInvalidException
    {
        File dir = new File(srcpath);
        if (!(dir.isDirectory()))
            throw new PathInvalidException ("");
    }
}