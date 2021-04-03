package pl.java.zadrekrut;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        List<String> fileContent = Reader.readFile();
        Calculator calculator = InputParser.getApplyCommand(fileContent);
        List<Instruction> instructions = InputParser.parseLines(fileContent);
        calculator.calculate(instructions);
    }
}
