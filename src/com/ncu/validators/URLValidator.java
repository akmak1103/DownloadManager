package com.ncu.validators;
import com.ncu.exceptions.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.HttpURLConnection; 
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

// Java program to validate an url in Java
public class URLValidator
{
	public boolean checkURL(String srcurl)
	{
		Properties prop = new Properties();
		Logger logger = Logger.getLogger(URLValidator.class);
		try
		{
			new URL(srcurl).toURI();
			urlExist(srcurl);
		}
		

		catch (URISyntaxException e)		// if URL cannot be converted into URI
		{
			logger.error(e.getMessage());
			return false;
		}
		catch (URLException e)
		{
			logger.error("\n\n"+e+prop.getProperty("urlDoesNotExistMessage"+"\n\n"));
        	return false;
		}
		
		catch (MalformedURLException e) 	// if protocol or address given in the url is incorrect
		{
			logger.error(e.getMessage());
			return false;
		}

		/*catch (Exception e)
		{
			logger.error(e.getMessage());
			return false;
		}*/
		return true;
	}
	
	public void urlExist (String url) throws URLException
	{
		int responseCode=0;
		try
		{
			URL urlfinal = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) urlfinal.openConnection();
			responseCode = huc.getResponseCode();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (responseCode == 404)
		{
		throw new URLException ("");
		}		
	}
}