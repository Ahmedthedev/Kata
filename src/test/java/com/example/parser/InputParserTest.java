package com.example.parser;

/**
 * Teste le parsing du fichier d'entrée.
 * 
 * Vérifie que les dimensions, positions et instructions sont correctement
 * extraites sous forme d'objets métier.
 */


 import com.example.domain.Instruction;
 import com.example.domain.Lawn;
 import com.example.domain.Orientation;
 import com.example.domain.Position;
 import org.junit.jupiter.api.Test;
 import java.util.List;
 import static org.assertj.core.api.Assertions.*;
 
 public class InputParserTest {
 
     @Test
     void shouldParseLawnDimensionsAndMowers() {
         String input = """
                 5 5
                 1 2 N
                 GAGAGAGAA
                 3 3 E
                 AADAADADDA
                 """;
 
         // when
         ParsedInput parsed = InputParser.parse(input);
 
         // then
         Lawn lawn = parsed.lawn();
         assertThat(lawn.isInside(new Position(5, 5))).isTrue();
 
         List<MowerSetup> mowers = parsed.mowers();
         assertThat(mowers).hasSize(2);
 
         MowerSetup mower1 = mowers.get(0);
         assertThat(mower1.mower().getPosition()).isEqualTo(new Position(1, 2));
         assertThat(mower1.mower().getOrientation()).isEqualTo(Orientation.N);
         assertThat(mower1.instructions()).containsExactly(
                 Instruction.G, Instruction.A, Instruction.G, Instruction.A,
                 Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.A);
     }
 }
