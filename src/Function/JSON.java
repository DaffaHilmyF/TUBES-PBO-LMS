/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author daffa
 */
public class JSON {
    
 
    
   // Print JSON from any object
    public static <T> void printJSON(T dataObject){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonData = gson.toJson(dataObject);
        System.out.println(jsonData);
    }
    
    public static <T> void printJSONExclude(T dataObject){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String jsonData = gson.toJson(dataObject);
        System.out.println(jsonData);
    }
   
    
    
}
