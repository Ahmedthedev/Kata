package com.example;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.example.parser.ParsedInput;
import com.example.parser.InputParser;

/**
 * Hello world!
 *
 */
public class App 
{
   public static void main(String[] args) throws Exception {

        // Chargement du fichier input.txt depuis le classpath
        InputStream is = App.class.getClassLoader().getResourceAsStream("input.txt");

        if (is == null) {
            System.err.println("[ERREUR] Fichier introuvable dans le classpath");
            return;
        }

        String input = new Scanner(is, StandardCharsets.UTF_8).useDelimiter("\\A").next();
        ParsedInput parsed = InputParser.parse(input);
    }
}
