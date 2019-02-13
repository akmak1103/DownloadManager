package com.ncu.validators;
import java.net.*;
public class URLValidator
{
    public static boolean checkURL(String url)
    {
    	try
    	{ 
            new URL (url).toURI(); 
            return true; 
        }
        catch (Exception e)
        {
        	e.printStackTrace();
            return false; 
        }
    }

    public static void main(String[] args)
    {
    	System.out.println(checkURL("https://www.google"));
    }
}