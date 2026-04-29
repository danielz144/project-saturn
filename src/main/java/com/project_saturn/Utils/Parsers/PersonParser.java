package com.project_saturn.Utils.Parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.project_saturn.Utils.Person;

public class PersonParser extends ParentParser {
    public PersonParser(File file) throws FileNotFoundException {
        super(file);
    }

    public ArrayList<Person> parse() {
        ArrayList<Person> people = new ArrayList<>();
        super.checkFile();

        while (super.scanner.hasNextLine()){
            String firstName = super.scanner.next();
            String lastName;
            if (!super.scanner.hasNext()) { System.err.println("Incorrect Format!"); }

            lastName = super.scanner.next();
            people.add(new Person(firstName, lastName));
        }

        return people;
    }

    @Override
    public String toString() {
        String people = "";
        for (Person person : parse()) {
            people += person.toString() + "\n";
        }
        return people;
    }
}
