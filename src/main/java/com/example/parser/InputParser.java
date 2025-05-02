package com.example.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.domain.Instruction;
import com.example.domain.Lawn;
import com.example.domain.Mower;
import com.example.domain.Orientation;
import com.example.domain.Position;

/**
 * Responsable de l'analyse du fichier d'entrée.
 * 
 * Cette classe lit les dimensions de la pelouse, les positions initiales et
 * les instructions des tondeuses, puis instancie les objets nécessaires à la
 * simulation.
 * 
 * Principe respecté : SRP (Single Responsibility Principle)
 * 
 * Ce parser simplifie la séparation entre données brutes (texte) et modèle
 * objet.
 */

public class InputParser {

    public static ParsedInput parse(String input) {
         Scanner scanner = new Scanner(input);
 
         int maxX = scanner.nextInt();
         int maxY = scanner.nextInt();
         scanner.nextLine(); 
 
         Lawn lawn = new Lawn(maxX, maxY);
         List<MowerSetup> mowers = new ArrayList<>();
 
         while (scanner.hasNextLine()) {
             String positionLine = scanner.nextLine().trim();
             if (positionLine.isEmpty()) continue;
 
             String[] parts = positionLine.split(" ");
             int x = Integer.parseInt(parts[0]);
             int y = Integer.parseInt(parts[1]);
             Orientation orientation = Orientation.valueOf(parts[2]);
 
             Mower mower = new Mower(new Position(x, y), orientation);
 
             // Ligne 2 : instructions
             String instructionLine = scanner.nextLine().trim();
             List<Instruction> instructions = new ArrayList<>();
             for (char c : instructionLine.toCharArray()) {
                 instructions.add(Instruction.fromChar(c));
             }
 
             mowers.add(new MowerSetup(mower, instructions));
         }
 
         return new ParsedInput(lawn, mowers);
     }
 
    
 }