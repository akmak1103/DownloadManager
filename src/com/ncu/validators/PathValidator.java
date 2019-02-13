package com.ncu.validators;
import java.io.*;
public class PathValidator
{
    public static boolean checkPath(String path)
    {
        File dir = new File(path);
        return dir.isDirectory();
    }
}