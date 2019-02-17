package com.ncu.validators;
import com.ncu.exceptions.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.HttpURLConnection; 
import java.util.*;
import org.apache.log4j.*;

// Java program to validate an url in Java
public class URLValidator
{
	public boolean checkURL(String srcurl)
	{
		Properties prop = new Properties();
		FileInputStream input = null;
		Logger logger = Logger.getLogger(URLValidator.class);
		PropertyConfigurator.configure("C:\\Users\\Akshay\\Desktop\\DownloadManager\\configs\\logger\\logger.properties");
		try
		{
			input = new FileInputStream("C:\\Users\\Akshay\\Desktop\\DownloadManager\\configs\\constants\\exceptions.properties");
			prop.load(input);
			new URL(srcurl).toURI();
			urlExist(srcurl);
		}
		

		catch (URISyntaxException e)		// if URL cannot be converted into URI
		{
			logger.error("\n"+e.getMessage()+"\n");
			return false;
		}
		catch (URLException e)
		{
			logger.error("\n"+e+(prop.getProperty("urlDoesNotExistMessage")));
        	return false;
		}
		
		catch (MalformedURLException e) 	// if protocol or address given in the url is incorrect
		{
			logger.error("\n"+e.getMessage()+"\n");
			return false;
		}

		catch (Exception e) 	
		{
			logger.error("\n"+e.getMessage()+"\n");
			return false;
		}
		
		return true;
	}
	
	public void urlExist (String url) throws URLException
	{
		int responseCode=0;
		HttpURLConnection huc = null;
		try
		{
			URL urlfinal = new URL(url);
			huc = (HttpURLConnection) urlfinal.openConnection();
			responseCode = huc.getResponseCode();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			huc.disconnect();
		}
		if (responseCode == 404)
		{
		throw new URLException ("");
		}		
	}
}