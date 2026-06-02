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
          result.append("INSERT INTO Rooms (location) VALUES");
          for (String location : locations) {
               result.append("('").append(location).append("'),\n");
          }
          result.delete(result.length() - 2, result.length()); // Remove the last comma and newline
          result.append(";");
          return result.toString();
     }
}
