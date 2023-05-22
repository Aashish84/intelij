package com.example.demo_ontology_mapper.controller;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@RestController
public class CreateController {
    private final String outputFilePath = "D:\\Sclara\\testing\\demo_ontology_mapper\\src\\main\\resources\\static\\ontology\\ontology_test.owl";
    //        defind namespace
    private final String ns = "http://example.com/ontology#";
    @GetMapping("/map-ontology")
    public String mapOntologyToDatabase() {
        OntModel ontModel = ModelFactory.createOntologyModel();

//        ontology class
        OntClass deviceClass = ontModel.createClass(ns + "Device");
        OntClass sensorClass = ontModel.createClass(ns + "Sensor");
        OntClass locationClass = ontModel.createClass(ns + "Location");

//        ontology properties
        Property hasSensorProperty = ontModel.createProperty(ns + "hasSensor");
        Property isLocatedAtProperty = ontModel.createProperty(ns + "isLocatedAt");

        deviceClass.addSuperClass(ontModel.createAllValuesFromRestriction(null, hasSensorProperty, sensorClass));
        deviceClass.addSuperClass(ontModel.createAllValuesFromRestriction(null, isLocatedAtProperty, locationClass));

        try {
            File file = new File(outputFilePath);
            if (file.exists()){
                boolean delete = file.delete();
                if(delete) System.out.println("old owl file deleted");
            }

            FileOutputStream fos = new FileOutputStream(outputFilePath);
            ontModel.write(fos, "RDF/XML");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Failed to generate ontology file ";
        }
        return "ontology generated";
    }

    @GetMapping("/populate-ontology")
    public String populateOntology() {
        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        ontModel.read(outputFilePath, null);

//        get ontology class and property
        OntClass deviceClass = ontModel.getOntClass(ns + "Device");
        OntClass sensorClass = ontModel.getOntClass(ns + "Sensor");
        OntClass locationClass = ontModel.getOntClass(ns + "Location");
        Property hasSensorProperty = ontModel.getProperty(ns + "hasSensor");
        Property isLocatedAtProperty = ontModel.getProperty(ns + "isLocatedAt");

//        create instance and add to the ontology
        Individual deviceInstance = deviceClass.createIndividual(ns + "Device001");
        Individual sensorInstance = sensorClass.createIndividual(ns + "Sensor001");
        Individual locationInstance = locationClass.createIndividual(ns + "Location001");

        deviceInstance.addProperty(hasSensorProperty, sensorInstance);
        deviceInstance.addProperty(isLocatedAtProperty, locationInstance);

//        save updated ontology
        try {
            FileOutputStream fos = new FileOutputStream(outputFilePath);
            ontModel.write(fos, "RDF/XML");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Failed to add instance on ontology file ";
        }
        return "instances added";
    }
    @GetMapping("/sparql-query")
    public String executeQuery() {
        String queryString = "PREFIX x: <http://example.com/ontology#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT ?instance\n" +
                "where {\n" +
                "  ?instance rdf:type x:Device \n" +
                "}";
        FileManager fileManager = FileManager.getInternal();
        Model model = ModelFactory.createOntologyModel();
        fileManager.readModelInternal(model, outputFilePath);

        Query query = QueryFactory.create(queryString);
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = queryExecution.execSelect();
        while (resultSet.hasNext()) {
            QuerySolution solution = resultSet.nextSolution();
            RDFNode s = solution.get("instance");
            if (s.isResource()) {
                Resource subject = s.asResource();
                System.out.println(" Subject : " + subject.getLocalName());
            }
        }
        resultSet.close();
        queryExecution.close();
        return "SPARQL query executed successfully.";
    }
}
