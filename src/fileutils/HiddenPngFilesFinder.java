package fileutils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HiddenPngFilesFinder {

    public static int count = 1;
    static double startTime;
    static double endTime;
    static double duration;
    public static void main(String[] args) {
        File[] drives = {
                new File("C:/"),
                new File("D:/"),
                new File("E:/"),
                new File("F:/"),
                new File("G:/"),
                new File("H:/")
        };
        List<File> hiddenPngFiles = new ArrayList<>();
        try {
            startTime = System.currentTimeMillis();

            for (File drive : drives) {
                listHiddenPngFiles(drive, hiddenPngFiles);
                System.out.println("Drive " + drive + " Scan Complete");
            }
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            duration /= 1000.0;

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Total files scanned: " + count);
        System.out.println("Total elapsed time: " + duration + "s");
        System.out.println("Hidden PNG files found: " + hiddenPngFiles.size());
        for (File file : hiddenPngFiles) {
            System.out.println("\t"+file.getAbsolutePath());
        }
    }


    public static void listHiddenPngFiles(File dir, List<File> hiddenPngFiles) throws SecurityException {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    try {
                        if (file.isDirectory()) {
                            if (file.isHidden()) {
                                hiddenPngFiles.add(file);
                            }
                            listHiddenPngFiles(file, hiddenPngFiles);
                        } else if (file.isHidden()) {
                            String fn = file.getName().toLowerCase();
                            if (fn.endsWith(".png") || fn.endsWith(".jpg") || fn.endsWith(".jpeg") || fn.endsWith(".tiff")){
                                hiddenPngFiles.add(file);
                            }
                        }
                    } catch (SecurityException se) {
                        System.err.println("Cannot access: " + file.getAbsolutePath() + " - " + se.getMessage());
                    }
                }
            }
        }
    }
}

