/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test_for_jsonschema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;



/**
 *
 * @author fstac
 */
public class Test4JSONSchema {
    
    
   
    
    public static void main(String[] args) throws FileNotFoundException{
        
        String fileName = "file1.json";
        String schemaName = "schema1.json";
        boolean ok = true;
        
        System.out.println("Check "+fileName+" with "+schemaName);
        
        //About the schema:
        File schemaFile = new File("jsonschema/"+schemaName);
        
        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject jsonSchema = new JSONObject( schemaData );
        
        //About the data file:
        File jsonData = new File ("jsonfile/" + fileName);
        JSONTokener jsonDataFile = new JSONTokener(new FileInputStream(jsonData));
        JSONObject jsonObject = new JSONObject(jsonDataFile);
        
        //validate and validation error handling
        Schema schemaValidator = SchemaLoader.load(jsonSchema);
        try {
            schemaValidator.validate(jsonObject);
        }
        catch(ValidationException e){
            List<String> violation = e.getAllMessages();
            
            violation.forEach(v ->{
                System.out.println(v);
            });
            
            ok = false;
        }
        //if pass:
        if (ok){
            System.out.println(jsonObject.getInt("id"));
            System.out.println(jsonObject.getJSONObject("rectangle").getInt("a"));
            System.out.println(jsonObject.getJSONObject("rectangle").getInt("b"));
        }
        //--------------------------------------------------
        
        //generate schema from class:
        TestSchemaGenerator tsg = new TestSchemaGenerator();
        tsg.generate();

        
    } 
}
