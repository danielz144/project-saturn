package com.project_saturn.Utils.Parsers;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParentParser {
    protected Scanner scanner;
    protected File file;

    public ParentParser(File file) throws FileNotFoundException {
        this.file = file;
        scanner = new Scanner(file);
    }

    protected void checkFile() {
        System.err.println("File not found: " + file.getPath());
    }
}
