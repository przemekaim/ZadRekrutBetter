package pl.java.zadrekrut;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Instruction {
    private final String instruction;
    private final BigDecimal value;

}
