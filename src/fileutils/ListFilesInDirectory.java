package fileutils;

import java.io.File;

public class ListFilesInDirectory
{
    public static void main(String[] args) {
        // Replace this with the path to the directory you want to list files from
        String directoryPath = "D:/ComfyUI/ComfyUI/models/checkpoints/SD1.5/";

        File directory = new File(directoryPath);

        // Check if the directory exists and is indeed a directory
        if (directory.exists() && directory.isDirectory()) {
            // List all files in the directory
            File[] fileList = directory.listFiles();

            if (fileList != null) {
                System.out.println("Files in the directory '" + directoryPath + "':");
                for (File file : fileList) {
                    // Check if the file object is indeed a file and not a directory
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The specified path is not a valid directory.");
        }
    }
}
