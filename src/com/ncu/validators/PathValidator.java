package com.ncu.validators;
import java.io.File;
import java.util.*;
import com.ncu.exceptions.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class PathValidator
{
    public static boolean checkPath(String path)
    {
    	Properties prop = new Properties();
        Logger logger = Logger.getLogger(PathValidator.class);
        try
        {
            pathExist(path);
        }    
        catch (PathInvalidException e)
        {
         	logger.error("\n\n"+e+prop.getProperty("pathInvalidMessage"+"\n\n"));
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