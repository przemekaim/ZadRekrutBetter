package pl.java.zadrekrut;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public static List<Instruction> parseLines(List<String> fileContent) {

        return fileContent.subList(0, fileContent.size() - 1).stream()
                .map(e -> e.split(" "))
                .peek(InputParser::checkFormat)
                .map(e -> new Instruction(e[0], BigDecimal.valueOf(Long.parseLong(e[1]))))
                .collect(Collectors.toList());
    }

    private static void checkFormat(String[] tokens) {
        if (tokens.length != 2)
            throw new RuntimeException("Wrong file format");
    }

    public static Calculator getApplyCommand(List<String> fileContent) {
        String lastLine = fileContent.get(fileContent.size() - 1);
        String[] tokens = lastLine.split(" ");
        checkFormat(tokens);
        if (!tokens[0].equalsIgnoreCase("apply"))
            throw new RuntimeException("Last line should contain apply command.");

        return new Calculator(new BigDecimal(tokens[1]));
    }
}
