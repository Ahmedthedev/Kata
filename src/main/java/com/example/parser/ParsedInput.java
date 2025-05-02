package com.example.parser;


import java.util.List;

import com.example.domain.Lawn;

public record ParsedInput(Lawn lawn, List<MowerSetup> mowers) {
}
