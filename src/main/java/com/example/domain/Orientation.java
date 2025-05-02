package com.example.domain;

public enum Orientation {
    N, E, S, W;

    public Orientation rotateLeft() {
        return switch (this) {
            case N -> W;
            case W -> S;
            case S -> E;
            case E -> N;
        };
    }

    public Orientation rotateRight() {
        return switch (this) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }

    public DirectionVector toVector() {
        return switch (this) {
            case N -> new DirectionVector(0, 1);
            case E -> new DirectionVector(1, 0);
            case S -> new DirectionVector(0, -1);
            case W -> new DirectionVector(-1, 0);
        };
    }
}