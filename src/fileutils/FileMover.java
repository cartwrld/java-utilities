package fileutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMover {

    public static void main(String[] args) {
        String sourceDirectoryPath = ""; // Replace with your source directory path
        String destinationDirectoryPath = ""; // Replace with your destination directory path

        File sourceDirectory = new File(sourceDirectoryPath);

        if (sourceDirectory.isDirectory()) {
            File[] files = sourceDirectory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().contains("")) {
                        File destFile = new File(destinationDirectoryPath, file.getName());

                        try {
                            copyFileUsingStream(file, destFile);
                            if (file.delete()) {
                                System.out.println("Processed and deleted: " + file.getName());
                            } else {
                                System.err.println("Failed to delete: " + file.getName());
                            }
                        } catch (IOException e) {
                            System.err.println("Error processing file: " + file.getName());
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.err.println("The provided source directory path does not point to a directory.");
        }
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
    }
}