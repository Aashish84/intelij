package com.example.demo_ontology_mapper.controller;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.apache.jena.util.FileManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OntologyController {
    private final String outputFilePath = "D:\\Sclara\\testing\\demo_ontology_mapper\\src\\main\\resources\\static\\ontology\\ontology_test.owl";

    @GetMapping("/populate-store")
    public String populateOntology2() {
        OntModel ontModel = ModelFactory.createOntologyModel();
        ontModel.read(outputFilePath, null);

//        get ontology class and property
        //        defind namespace
        String ns = "http://example.com/ontology#";

        OntClass deviceClass = ontModel.getOntClass(ns + "Device");
        OntClass sensorClass = ontModel.getOntClass(ns + "Sensor");
        OntClass locationClass = ontModel.getOntClass(ns + "Location");
        Property hasSensorProperty = ontModel.getProperty(ns + "hasSensor");
        Property isLocatedAtProperty = ontModel.getProperty(ns + "isLocatedAt");

//        create instance and add to the ontology
        Individual deviceInstance = deviceClass.createIndividual(ns + "Device002");
        Individual sensorInstance = sensorClass.createIndividual(ns + "Sensor002");
        Individual locationInstance = locationClass.createIndividual(ns + "Location002");

        deviceInstance.addProperty(hasSensorProperty, sensorInstance);
        deviceInstance.addProperty(isLocatedAtProperty, locationInstance);

//        save updated ontology to triple store
        String fusekiURL = "http://localhost:3030/#/dataset/test_02";

        try(RDFConnection connection = RDFConnectionFuseki.create().destination(fusekiURL).build()){
//            upload ontology model
            connection.load(ontModel.getRawModel());

//            upload instances
            connection.load(deviceInstance.getModel());
            connection.load(sensorInstance.getModel());
            connection.load(locationInstance.getModel());
        }catch (Exception e){
            e.printStackTrace();
            return "Failed to populate ontology.";
        }
        return "Ontology populated and instances saved in the triple store.";
    }

    @GetMapping("/fetch")
    public String fetchData(){
        String fusekiURL = "http://localhost:3030/#/dataset/dbo_110";
        try (RDFConnection connection = RDFConnectionFuseki.create().destination(fusekiURL).build()) {
            // Query for fetching all triples
            String sparqlQuery = "SELECT ?subject ?predicate ?object WHERE { ?subject ?predicate ?object } limit 10";

            // Execute the SPARQL query
            QueryExecution queryExecution = connection.query(sparqlQuery);
            ResultSet resultSet = queryExecution.execSelect();

            // Iterate over the result set and print the triplets
            StringBuilder result = new StringBuilder();
            while (resultSet.hasNext()) {
                QuerySolution solution = resultSet.nextSolution();
                RDFNode s = solution.get("s");
                RDFNode p = solution.get("p");
                RDFNode o = solution.get("o");
                if (s.isResource() && p.isResource() && o.isResource()) {
                    Resource subject = s.asResource();
                    Resource predicate = p.asResource();
                    Resource object = o.asResource();

                    result.append("Subject: ").append(subject.toString());
                    result.append(" Predicate: ").append(predicate.toString());
                    result.append(" Object: ").append(object.toString());
                    result.append("\n");
                }
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to fetch triplets.";
        }
    }

    @GetMapping("/sparql-query2")
    public String executeQuery2() {
        String queryString = "prefix x:<http://example.com/ontology#> select ?s ?p ?o where {?s ?p ?o} limit 100";
        Query query = QueryFactory.create(queryString);
        QueryExecution queryExecution = null;
        ResultSet resultSet = null;
        try {
            FileManager fileManager = FileManager.getInternal();
            Model model = ModelFactory.createOntologyModel();
            fileManager.readModelInternal(model, outputFilePath);
//            OntModel ontModel = ModelFactory.createOntologyModel();
//            ontModel.read(outputFilePath, null);

            queryExecution = QueryExecutionFactory.create(query, model);
            resultSet = queryExecution.execSelect();
            while (resultSet.hasNext()) {
                QuerySolution solution = resultSet.nextSolution();
                RDFNode s = solution.get("s");
                RDFNode p = solution.get("p");
                RDFNode o = solution.get("o");
                if (s.isResource() && p.isResource() && o.isResource()) {
                    Resource subject = s.asResource();
                    Resource predicate = p.asResource();
                    Resource object = o.asResource();
                    System.out.print(" Subject : " + subject.toString());
                    System.out.print(" predicate : " + predicate.toString());
                    System.out.print(" object : " + object.toString());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to execute SPARQL query.";
        } finally {
            if (resultSet != null) resultSet.close();
            if (queryExecution != null) queryExecution.close();
        }
        return "SPARQL query executed successfully.";
    }
}
