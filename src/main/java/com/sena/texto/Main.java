package com.sena.texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File archivo = new File("texto\\src\\main\\java\\com\\sena\\texto\\texto.txt");
            Scanner scanner = new Scanner(archivo);

            String texto = scanner.useDelimiter("\\A").next();
            scanner.close();

            String[] palabras = texto.split("\\s+");
            int numPalabras = palabras.length;
            int numOraciones = texto.split("\\. ").length;

            Map<String, Integer> frecuenciaPalabras = new HashMap<>();
            for (String palabra : palabras) {
                frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
            }
            String palabraMasFrecuente = frecuenciaPalabras.entrySet().stream()
                   .max((a, b) -> a.getValue().compareTo(b.getValue())).get().getKey();

            int longitudTotal = 0;
            for (String palabra : palabras) {
                longitudTotal += palabra.length();
            }
            double longitudPromedio = (double) longitudTotal / numPalabras;

            System.out.println("Estadísticas del texto:");
            System.out.println("Número total de palabras: " + numPalabras);
            System.out.println("Número total de oraciones: " + numOraciones);
            System.out.println("Palabra más frecuente: " + palabraMasFrecuente);
            System.out.println("Longitud promedio de las palabras: " + longitudPromedio);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}