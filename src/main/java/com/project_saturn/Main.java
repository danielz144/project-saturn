package com.project_saturn;

import java.io.File;
import java.io.FileNotFoundException;

import com.project_saturn.Utils.Parsers.PersonParser;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PersonParser parser = new PersonParser(new File("src\\main\\java\\com\\project_saturn\\Infos\\Mock_Students"));
        System.out.println(parser);
    }
}