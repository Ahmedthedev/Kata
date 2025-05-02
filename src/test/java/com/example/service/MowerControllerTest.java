package com.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.domain.Instruction;
import com.example.domain.Lawn;
import com.example.domain.Mower;
import com.example.domain.Orientation;
import com.example.domain.Position;
import static org.assertj.core.api.Assertions.*;

/**
 * Teste la logique d'exécution des instructions sur une tondeuse individuelle.
 * 
 * Vérifie que chaque instruction ("G", "D", "A") modifie correctement
 * l'état de la tondeuse (position ou orientation) en fonction de sa
 * situation actuelle et des limites de la pelouse.
 * 
 */

 public class MowerControllerTest {

    private Mower mower;
    private Lawn lawn;
    private MowerController controller;

    @BeforeEach
    void setup() {
        mower = new Mower(new Position(1, 1), Orientation.N);
        lawn = new Lawn(5, 5);
        controller = new MowerController(mower, lawn);
    }

    @Test
    void shouldRotateLeft() {
        controller.apply(Instruction.G);
        assertThat(mower.getOrientation()).isEqualTo(Orientation.W);
    }

    @Test
    void shouldRotateRight() {
        controller.apply(Instruction.D);
        assertThat(mower.getOrientation()).isEqualTo(Orientation.E);
    }

    @Test
    void shouldMoveForwardWhenInsideLawn() {
        controller.apply(Instruction.A);
        assertThat(mower.getPosition()).isEqualTo(new Position(1, 2));
    }

    @Test
    void shouldNotMoveOutsideLawn() {
        mower = new Mower(new Position(0, 0), Orientation.S);
        controller = new MowerController(mower, lawn);
        controller.apply(Instruction.A);
        assertThat(mower.getPosition()).isEqualTo(new Position(0, 0)); // pas de déplacement
    }

    @Test
    void shouldThrowOnUnknownInstruction() {
        assertThatThrownBy(() -> controller.apply(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Instruction inconnue");
    }
}
