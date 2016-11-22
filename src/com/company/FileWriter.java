package com.company;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileWriter {
    private String fileName;

    private PrintStream out;

    public FileWriter(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        out = new PrintStream(this.fileName);
    }

    public void writeIntToFile(int i) {
        out.println(i);
    }

    public void writeStringToFile(String s){
        out.println(s);
    }
}
