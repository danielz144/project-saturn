package com.project_saturn;

import com.project_saturn.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    protected Scanner scanner;
    protected File file;

    public Parser(File file) throws FileNotFoundException {
        this.file = file;
        scanner = new Scanner(file);
    }

    protected void checkFile() {
        System.err.println("File not found: " + file.getPath());
    }
}

class PersonParser extends Parser {
    public PersonParser(File file) throws FileNotFoundException {
        super(file);
    }

    public ArrayList<Person> parse() {
        ArrayList<Person> people = new ArrayList<>();
        super.checkFile();

        while (super.scanner.hasNextLine()){
            String line = super.scanner.nextLine();
            String[] parts = line.split(","); // Assuming CSV format: firstName,lastName

            if (parts.length < 2){ System.err.println("Invalid person format for file: " + super.file.getPath()); }
            
        }

        return people;
    }
}
