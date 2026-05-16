package com.project_saturn.Project_Tables;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.project_saturn.Utils.Parsers.LineParser;

public class RoomsTable {
     private static ArrayList<String> locations = new ArrayList<>();

     public static void createTable() {
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
          String result = "";
          for (String location : locations) {
               result += "INSERT INTO Rooms (location) VALUES (" + location + ")\n";
          }
          return result;
     }
}