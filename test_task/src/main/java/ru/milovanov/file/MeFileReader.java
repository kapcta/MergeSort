package ru.milovanov.file;

import java.io.*;


public class MeFileReader {
    String fileName;
    BufferedReader reader;

    public MeFileReader(String filePath) throws IOException {
        //this.fileName = filePath;
        this.reader  = new BufferedReader(new FileReader(filePath));
    }

    //BufferedReader reader = new BufferedReader(new FileReader(fileName));
    public String readFileByChar() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

}

