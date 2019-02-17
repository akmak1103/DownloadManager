package com.ncu.processors;
import java.io.*;
import java.net.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DownloadedFile
{
	String name,size,type,location,date,status;

	DownloadedFile(String fname, String path, String url)
	{
		this.name = fname;
		this.size = getSize(url);
		this.location = path;
		this.type = getType(url);
		this.status = getStatus(path,fname);
		this.date = dateModified();
	}

	public String getSize(String sourceURL)
	{
		long s = 0;
		HttpURLConnection connection = null;
		try
		{
			URL url=new URL(sourceURL);
 			connection = (HttpURLConnection) url.openConnection();
 			s = connection.getContentLength();
 			s = (Long) s/1024;
 		}
 		catch (Exception e)
 		{
 			e.printStackTrace();
 		}
 		finally
 		{
 			connection.disconnect();
 		}
 		return (Long.toString(s)+"MB");
	}

	public String getType(String sourceURL)
	{
		int place = sourceURL.lastIndexOf(".");
		return (sourceURL.substring((place+1)));
	}

	public String getStatus(String path,String filename)
	{
		File file = new File(path+"\\"+filename);
		return (Boolean.toString(file.exists()));
	}

	public String dateModified()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   		LocalDateTime now = LocalDateTime.now();  
   		return (dtf.format(now));
   	}
}