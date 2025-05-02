package com.example.service;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.domain.Instruction;
import com.example.domain.InstructionUtils;
import com.example.domain.Lawn;
import com.example.domain.Mower;
import com.example.domain.Orientation;
import com.example.domain.Position;
import com.example.parser.MowerSetup;
import com.example.parser.ParsedInput;
import static org.assertj.core.api.Assertions.*;

/**
 * Teste la logique de simulation multi-tondeuses.
 * 
 * Chaque tondeuse doit exécuter sa séquence indépendamment et produire
 * la bonne position finale.
 */


 public class MowerSimulationTest {

    @Test
    void shouldSimulateAllMowersCorrectly() {
        // given
        Lawn lawn = new Lawn(5, 5);

        Mower mower1 = new Mower(new Position(1, 2), Orientation.N);
        List<Instruction> instructions1 = InstructionUtils.parse("GAGAGAGAA");

        Mower mower2 = new Mower(new Position(3, 3), Orientation.E);
        List<Instruction> instructions2 = InstructionUtils.parse("AADAADADDA");

        ParsedInput input = new ParsedInput(
            lawn,
            List.of(
                new MowerSetup(mower1, instructions1),
                new MowerSetup(mower2, instructions2)
            )
        );

        // when
        List<Mower> result = MowerSimulation.run(input);

        // then
        assertThat(result).hasSize(2);

        Mower finalMower1 = result.get(0);
        assertThat(finalMower1.getPosition()).isEqualTo(new Position(1, 3));
        assertThat(finalMower1.getOrientation()).isEqualTo(Orientation.N);

        Mower finalMower2 = result.get(1);
        assertThat(finalMower2.getPosition()).isEqualTo(new Position(5, 1));
        assertThat(finalMower2.getOrientation()).isEqualTo(Orientation.E);
    }
}
 