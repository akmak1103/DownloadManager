/*
Author: Aashima, Aditya, Akshay, Anmol Nagpal, Anmol Sarpal
Project: Download Manager
*/

package com.ncu.processors;
import java.io.*;
import java.util.*;

public class ListAppender
{
	public void CSVwriter (String fName,String location, String srcURl)
	{
    	DownloadedFile dFile = new DownloadedFile (fName,location,srcURl);     //creates object and sets the parameter values

    	FileWriter fileWriter = null;
    	
    	try
    	{
    		fileWriter = new FileWriter("C:\\Users\\Akshay\\Desktop\\DownloadManager\\downloads\\ListOfDownloads.csv",true);      //'true' is for append mode
    		fileWriter.append("\n"+dFile.name+","+dFile.size+","+dFile.type+","+dFile.date+","+dFile.location+","+dFile.status);      //appends data at the end
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
    			ie.printStackTrace();
    		}
    	}
    }
}