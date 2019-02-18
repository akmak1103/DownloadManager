/*
Author: Aashima, Aditya, Akshay, Anmol Nagpal, Anmol Sarpal
Project: Download Manager
*/
package com.ncu.processors;
import java.io.*;
import java.net.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DownloadedFile
{
	String name,size,type,location,date,status;		//instance variables

	DownloadedFile(String fname, String path, String url)		//constructor
	{
		this.name = fname;
		this.size = getSize(url);
		this.location = path;
		this.type = getType(url);
		this.status = getStatus(path,fname);
		this.date = dateModified();
	}

	public String getSize(String sourceURL)		//to fetch size from url
	{
		double s = 0;
		HttpURLConnection connection = null;
		try
		{
			URL url=new URL(sourceURL);
 			connection = (HttpURLConnection) url.openConnection(); 		// establishes connection with url
 			s = connection.getContentLength();
 			s = (double)(s/(1024*1024)); 		//converts size to MB
 		}
 		catch (Exception e)
 		{
 			e.printStackTrace();
 		}
 		finally
 		{
 			connection.disconnect(); 		//to close the connection
 		}
 		return (String.format("%.2f",s)+"MB");		// specifies no. of decimal places
	}

	public String getType(String sourceURL)		//fetches type of file via url
	{
		int place = sourceURL.lastIndexOf(".");
		return (sourceURL.substring((place+1)));
	}

	public String getStatus(String path,String filename)	//final status
	{
		File file = new File(path+"\\"+filename);
		return (Boolean.toString(file.exists()));	//returns true if file exists
	}

	public String dateModified()		// time of downloading
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   		LocalDateTime now = LocalDateTime.now();  
   		return (dtf.format(now));
   	}
}