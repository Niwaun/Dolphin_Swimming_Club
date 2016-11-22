package com.company;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class FileWriter {
    private String fileName;
    private PrintStream out;

    public FileWriter(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        out = new PrintStream(this.fileName);
    }

    public void writeMemberToFile(ArrayList member){
        out.println(member);
    }
}
