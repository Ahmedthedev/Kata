package com.example.domain;

import lombok.Getter;
import lombok.AllArgsConstructor;


@Getter
@AllArgsConstructor
public class Mower {
    private Position position;
    private Orientation orientation;

    public void rotateLeft() {
        this.orientation = orientation.rotateLeft();
    }

    public void rotateRight() {
        this.orientation = orientation.rotateRight();
    }

    public void moveForward(Lawn lawn) {
        Position next = position.move(orientation.toVector());
        if (lawn.isInside(next)) {
            this.position = next;
        }
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + orientation;
    }
}
