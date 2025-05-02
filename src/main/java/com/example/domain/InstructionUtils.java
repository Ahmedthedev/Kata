package com.example.domain;

import java.util.List;
import java.util.stream.Collectors;

public class InstructionUtils {
    public static List<Instruction> parse(String instructionLine) {
        return instructionLine.chars()
                .mapToObj(c -> Instruction.fromChar((char) c))
                .collect(Collectors.toList());
    }
}

