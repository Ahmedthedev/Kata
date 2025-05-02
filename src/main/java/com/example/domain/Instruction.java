package com.example.domain;

public enum Instruction {
    A, G, D;

    public static Instruction fromChar(char c) {
        return switch (c) {
            case 'A' -> A;
            case 'G' -> G;
            case 'D' -> D;
            default -> throw new IllegalArgumentException("Instruction inconnue : " + c);
        };
    }
}
