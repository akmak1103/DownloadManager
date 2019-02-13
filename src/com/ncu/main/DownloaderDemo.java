package com.ncu.main;
import java.util.*;
import com.ncu.exceptions.*;
import com.ncu.validators.*;
import com.ncu.processors.*;
public class DownloaderDemo
{
	public static void main(String[] args)
	{
		Downloader obj = new Downloader();
		Scanner scan = new Scanner(System.in);
		

		System.out.println("Enter the URL of file to be downloaded: ");
		URLValidator validURL = new URLValidator();
		obj.url = scan.nextLine();
		boolean isFileURLOk = validURL.checkURL(obj.url);


		System.out.println("Enter the destination folder for the downloaded file: ");
		PathValidator validPath = new PathValidator();
		obj.path = scan.nextLine();
		boolean isPathOk = validPath.checkPath(obj.path);
		

		if (isFileURLOk && isPathOk)
		obj.downloader(); 	
	}
}