package com.example;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.domain.Mower;
import com.example.parser.InputParser;
import com.example.parser.ParsedInput;
import com.example.service.MowerSimulation;
import static org.assertj.core.api.Assertions.*;

public class AppTest {

    @Test
    void shouldRunSimulationEndToEnd() {
        // given
        String input = """
            5 5
            1 2 N
            GAGAGAGAA
            3 3 E
            AADAADADDA
            """;

        // when
        ParsedInput parsed = InputParser.parse(input);
        List<Mower> result = MowerSimulation.run(parsed);

        // then
        assertThat(result).hasSize(2);
        assertThat(result.get(0).toString()).isEqualTo("1 3 N");
        assertThat(result.get(1).toString()).isEqualTo("5 1 E");
    }
}
