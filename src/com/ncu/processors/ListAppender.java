package com.ncu.processors;
import java.io.*;
import java.util.*;

public class ListAppender
{
	public void CSVwriter (String fName,String location, String srcURl)
	{
    	final String LINE_SEPARATOR = "\n";
    	DownloadedFile dFile = new DownloadedFile (fName,location,srcURl);

    	FileWriter fileWriter = null;
    	
    	try
    	{
    		fileWriter = new FileWriter("C:\\Users\\Akshay\\Desktop\\DownloadManager\\downloads\\ListOfDownloads.csv",true);
    		fileWriter.append("\n"+dFile.name+","+dFile.size+","+dFile.type+","+dFile.date+","+dFile.location+","+dFile.status);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    	finally
    	{
    		try
    		{
    			fileWriter.close();
    		}
    		catch(IOException ie)
    		{
    			System.out.println("Error occured while closing the fileWriter");
    			ie.printStackTrace();
    		}
    	}
    }
}