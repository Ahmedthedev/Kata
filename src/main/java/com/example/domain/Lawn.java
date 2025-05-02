package com.example.domain;

public class Lawn {
    private final int maxX;
    private final int maxY;

    public Lawn(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isInside(Position p) {
        return p.getX() >= 0 && p.getX() <= maxX && p.getY() >= 0 && p.getY() <= maxY;
    }
}
