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
		int choice = 0;
		int count = 0;
		Downloader obj = new Downloader();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\n-------------------------------\n-------------------------------");
		System.out.println("Welcome to Download Manager");
		System.out.println("-------------------------------\n-------------------------------\n\n");

		do
		{
			count += 1;
			System.out.print("Enter the URL of file to be downloaded:  ");
			URLValidator validURL = new URLValidator();
			if (!(count==1)){scan.nextLine();}
			obj.url = scan.nextLine();
			System.out.println();
			boolean isFileURLOk = validURL.checkURL(obj.url);


			System.out.print("Enter the destination folder for the downloaded file:  ");
			PathValidator validPath = new PathValidator();
			obj.path = scan.nextLine();
			System.out.println();
			boolean isPathOk = validPath.checkPath(obj.path);
		
			System.out.print("Enter the filename (with EXTENSION):  ");
			obj.fName = scan.nextLine();		

			if (isFileURLOk && isPathOk)
			{
				obj.downloadFile(obj.url,obj.path,obj.fName);
				System.out.println("\n\nDownload will begin now :)");
			}

			ListAppender updateCSV = new ListAppender();
			updateCSV.CSVwriter(obj.fName,obj.path,obj.url);

			System.out.print("\n\nDo you want to download another file??");
			System.out.print("\t\tPress '1' for YES");
			System.out.println("\t\tPress '0' for NO");
			choice = scan.nextInt();
			System.out.println("\n\n");
		}
		while (choice==1);

		System.out.println("\n\n-------------------------------------------\n-------------------------------------------");
		System.out.println("Thank You for using our application :) :)");
		System.out.println("-------------------------------------------\n-------------------------------------------");

	}
}