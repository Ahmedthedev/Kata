/**
 * Simule l'exécution séquentielle de toutes les tondeuses sur la pelouse.
 * 
 * Cette classe orchestre la lecture des entrées, l'exécution des instructions,
 * et la collecte des positions finales.
 * 
 * Elle constitue le cœur de l'application côté service, en séparant
 * complètement la logique métier du parsing et de l'affichage.
 */

 package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Instruction;
import com.example.domain.Lawn;
import com.example.domain.Mower;
import com.example.parser.MowerSetup;
import com.example.parser.ParsedInput;

public class MowerSimulation {

    public static List<Mower> run(ParsedInput input) {
        Lawn lawn = input.lawn();
        List<Mower> result = new ArrayList<>();

        for (MowerSetup setup : input.mowers()) {
            Mower mower = setup.mower();
            List<Instruction> instructions = setup.instructions();

            MowerController controller = new MowerController(mower, lawn);

            for (Instruction instruction : instructions) {
                controller.apply(instruction);
            }

            result.add(mower);
        }

        return result;
    }
  
}