/*
Author: Aashima, Aditya, Akshay, Anmol Nagpal, Anmol Sarpal
Project: Download Manager
*/

package com.ncu.main;
import java.util.*;
import java.io.*;
import com.ncu.exceptions.*;
import com.ncu.validators.*;
import com.ncu.processors.*;
public class DownloaderDemo
{
	public static void main(String[] args)
	{
		Downloader obj = new Downloader();
		Scanner scan = new Scanner(System.in);
		
		//intro

		System.out.println("\n\n\t\t\t\t\t\t-------------------------------\n\t\t\t\t\t\t-------------------------------");
		System.out.println("\t\t\t\t\t\t  Welcome to Download Manager");
		System.out.println("\t\t\t\t\t\t-------------------------------\n\t\t\t\t\t\t-------------------------------\n\n");

		//URL validation
		System.out.print("Enter the URL of file to be downloaded:  ");
		URLValidator validURL = new URLValidator();
		obj.url = scan.nextLine();
		System.out.println();
		boolean isFileURLOk = validURL.checkURL(obj.url);


		//Path validation
		System.out.println("Downloaded file should be saved to?\t1.Default Path\t2.Custom Path\nEnter your choice:");
		int choice = scan.nextInt();
		boolean isPathOk = true;
		switch (choice)
		{
			case 2:
			System.out.print("Enter the destination folder for the downloaded file:  ");
			PathValidator validPath = new PathValidator();
			obj.path = scan.nextLine();
			System.out.println();
			isPathOk = validPath.checkPath(obj.path);
			break;

			case 1:
			obj.path = "C:\\Users\\Akshay\\Desktop\\DownloadManager\\downloads";
			break;
		}
		


		System.out.print("Enter the filename :  "); scan.nextLine();
		obj.fName = scan.nextLine();
		String extension = (obj.url.substring((obj.url.lastIndexOf("."))));
		obj.fName = obj.fName+extension;




		//downloads file if both validations are true
		if (isFileURLOk && isPathOk)
		{
			System.out.println("\nDownload will begin now :)\n");
			obj.downloadFile(obj.url,obj.path,obj.fName);
		}

		ListAppender updateCSV = new ListAppender();
		updateCSV.CSVwriter(obj.fName,obj.path,obj.url);		//for writing to CSV file 'ListOfDownloads.csv'

		System.out.println("\n\n\t\t\t\t\t-------------------------------------------\n\t\t\t\t\t-------------------------------------------");
		System.out.println("\t\t\t\t\t Thank You for using our application :) :)");
		System.out.println("\t\t\t\t\t-------------------------------------------\n\t\t\t\t\t-------------------------------------------");

	}
}