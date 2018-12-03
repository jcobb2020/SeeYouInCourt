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

    public List<String> getJSONStringsFromDirectory(String directory) {
        File folder = new File(directory);
        return getJSONStrings(folder);
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

    private List<String> getJSONStrings(final File folder) {
        List<String> jsons = new ArrayList<String>();

        for (final File fileEntry : folder.listFiles()) {
            String filename = fileEntry.getName();
            //System.out.println(filename);
            if (filename.endsWith(".json")) {
                Path filePath = fileEntry.toPath();
                try {
                    BufferedReader reader = Files.newBufferedReader(filePath);
                    jsons.add(dropMetaData(reader.readLine()));
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileEntry.isDirectory()) {
                getJSONStrings(fileEntry);
            }
        }
        return jsons;
    }

//    public void jsonPrinter(List<String> jsons) {
//        for (String json : jsons) {
//            System.out.println(json);
//        }
//    }
    private String dropMetaData(String json){
            int beg = json.indexOf("items") + 7;
            int end = json.indexOf("queryTemplate") - 2;
            return json.substring(beg,end);
    }
}
