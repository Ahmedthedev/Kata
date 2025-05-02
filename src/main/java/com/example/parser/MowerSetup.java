package com.example.parser;


import java.util.List;
import com.example.domain.Instruction;
import com.example.domain.Mower;

public record MowerSetup(Mower mower, List<Instruction> instructions) {
}
