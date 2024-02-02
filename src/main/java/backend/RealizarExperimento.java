/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author labctr
 */
public class RealizarExperimento {
    double altura;
    double tiempo;
    double velocidad;

    public RealizarExperimento(double altura, double tiempo) {
        this.altura = altura;
        this.tiempo = tiempo;
    }
  
    public double calcular(){
        // vf = v0 + gt
        velocidad = (float) (9.8*this.tiempo);      
        return velocidad;
    }
    
    
    
   
    public List<Document> consultarDatos() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("Objetos");
            MongoCollection<Document> calculoCollection = database.getCollection("calculo");

            List<Document> areasFiltradas = new ArrayList<>();

            try (MongoCursor<Document> cursor = calculoCollection.find(Filters.eq("tipo", "Objeto")).iterator()) {
                while (cursor.hasNext()) {
                    areasFiltradas.add(cursor.next());
                }
            }

            return areasFiltradas;
        } catch (Exception e) {
            System.err.println("Error al obtener los calculos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    

    public String guardarBDD() {
        try {
            try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                MongoDatabase database = mongoClient.getDatabase("Objetos");
                MongoCollection<Document> calculoCollection = database.getCollection("calculo");
                
                Document datosDocument = new Document("tipo", "Objeto")
                        .append("tiempo", this.tiempo)
                        .append("altura", this.altura)
                        .append("velocidad", calcular());
                
                calculoCollection.insertOne(datosDocument);
            }

            return "Área de círculo guardada en la base de datos.";
        } catch (Exception e) {
            return "Error al guardar el área de círculo en la base de datos: " + e.getMessage();
        }
    }

    public String vaciarDatos() {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("Objetos");
            MongoCollection<Document> calculoCollection = database.getCollection("calculo");

            calculoCollection.deleteMany(Filters.eq("tipo", "Objeto"));

            mongoClient.close();

            return "Datos eliminados de la base de datos.";
        } catch (Exception e) {
            return "Error al eliminar los datos: " + e.getMessage();
        }
    }
    
    
}
