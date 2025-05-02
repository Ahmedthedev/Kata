package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.EqualsAndHashCode;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Position {
    private final int x;
    private final int y;

    public Position move(DirectionVector vector) {
        return new Position(x + vector.dx(), y + vector.dy());
    }
}
