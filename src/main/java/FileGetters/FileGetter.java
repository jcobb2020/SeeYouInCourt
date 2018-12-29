package FileGetters;

import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileGetter {

    public String getDirectory() {
        System.out.println("Input Directory");
        Scanner scanner = new Scanner(System.in);
        String directory = scanner.next();
        return directory;
    }

    public List<String> getHTMLStringsFromDirectory(String directory){
        File folder = new File(directory);
        return getFILEStrings(folder, FileType.html);
    }

    public List<String> getJSONStringsFromDirectory(String directory) {
        File folder = new File(directory);
        return getFILEStrings(folder, FileType.json);
    }


    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }

    private List<String> getFILEStrings(final File folder, FileType f) {
        List<String> filess = new ArrayList<String>();
        try {
            for (final File fileEntry : folder.listFiles()) {
                String filename = fileEntry.getName();
                //System.out.println(filename);
                if (fileEntry.isDirectory()) {
                    filess.addAll(getFILEStrings(fileEntry, f));
                }
                if (filename.endsWith("." + f)) {
                    Path filePath = fileEntry.toPath();
                    try {
                        BufferedReader reader = Files.newBufferedReader(filePath);
                        if (f == FileType.json) {
                            filess.add(dropMetaData(reader.readLine()));
                        } else {
                            StringBuilder builder = new StringBuilder();
                            while (true) {
                                String a = reader.readLine();
                                if (a == null) {
                                    break;
                                }
                                builder.append(a);

                            }
                            filess.add(builder.toString());
                        }
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (NullPointerException e){
            return filess;
        }
        return filess;
    }


    //    public void jsonPrinter(List<String> jsons) {
//        for (String json : jsons) {
//            System.out.println(json);
//        }
//    }
    private String dropMetaData(String json) {
        int beg = json.indexOf("items") + 7;
        int end = json.indexOf("queryTemplate") - 2;
        return json.substring(beg, end);
    }
}
