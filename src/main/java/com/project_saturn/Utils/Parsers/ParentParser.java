package com.project_saturn.Utils.Parsers;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParentParser {
    protected Scanner scanner;
    protected File file;

    public ParentParser(File file) {
        this.file = file;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    protected void checkFile() {
        if (file != null) { return; }
        System.err.println("File not found: " + file.getPath());
    }
}
