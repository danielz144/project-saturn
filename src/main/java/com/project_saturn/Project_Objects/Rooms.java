package com.project_saturn.Project_Objects;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.project_saturn.Utils.Parsers.LineParser;

public class Rooms {
     private static ArrayList<String> locations = new ArrayList<>();

     public static void populateTable() {
          File locationFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Mock_Rooms").toFile();
          LineParser locationParser = new LineParser(locationFile);
          ArrayList<String> locationsList = locationParser.parse();

          for (String location : locationsList){
               locations.add(location);
          }
     }

     public static ArrayList<String> getLocations() {
          return locations;
     }

     public static String getInsertStatements() {
          StringBuilder result = new StringBuilder();
          for (String location : locations) {
               result.append("INSERT INTO Rooms (location) VALUES ('").append(location).append("');\n");
          }
          return result.toString();
     }
}
