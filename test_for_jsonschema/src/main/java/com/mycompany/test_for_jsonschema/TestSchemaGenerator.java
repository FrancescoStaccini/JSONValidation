/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test_for_jsonschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfig;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;
import java.io.File;
import java.util.List;


/**
 *
 * @author fstac
 */

//info --> https://github.com/victools/jsonschema-generator

public class TestSchemaGenerator {
    
    private String myString;
    private int n;
    
    File myFile;
    List<Object> myList;
    List<List<Double>> anotherList;
    

    public void generate(){
    
        SchemaGeneratorConfigBuilder configBuilder =
        new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode newJsonSchema = generator.generateSchema(this.getClass());

        System.out.println(newJsonSchema.toString());
    
    }
    
}
