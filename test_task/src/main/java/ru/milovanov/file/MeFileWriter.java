package ru.milovanov.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class MeFileWriter {

    //String fileName;
    PrintWriter writer;
    public MeFileWriter (String filePath) throws FileNotFoundException, UnsupportedEncodingException {

        //this.fileName = filePath;
        this.writer = new PrintWriter(filePath, String.valueOf(StandardCharsets.UTF_8));

    }

    public void writeByChar(String str) throws FileNotFoundException, UnsupportedEncodingException {
        //PrintWriter writer = new PrintWriter(fileName, String.valueOf(StandardCharsets.UTF_8));
        writer.println(str);
        writer.close();

    }
}
