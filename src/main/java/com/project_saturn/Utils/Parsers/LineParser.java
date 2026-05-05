package com.project_saturn.Utils.Parsers;

import java.io.File;
import java.util.ArrayList;

public class LineParser extends ParentParser {
    /**
     * Note: Call toString() on the parser to get the ArrayList of Person objects in the file.
     * 
     * @param file
     */
    public LineParser(File file) {
        super(file);
    }

    /**
     * Parses the file and returns an ArrayList of Person objects.
     * @return ArrayList<Person>
     */
    public ArrayList<String> parse() {
        ArrayList<String> arrayList = new ArrayList<>();
        super.checkFile();

        while (super.scanner.hasNextLine()){
            arrayList.add(super.scanner.nextLine());
        }

        return arrayList;
    }

    @Override
    public String toString() {
        String entireStr = "";
        for (String str : parse()) {
            entireStr += str.toString() + "\n";
        }
        return entireStr;
    }
}

