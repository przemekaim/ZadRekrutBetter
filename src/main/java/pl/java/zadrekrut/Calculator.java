package pl.java.zadrekrut;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    private final BigDecimal initValue;
    private final Map<String, BiFunction<BigDecimal, BigDecimal, BigDecimal>> map = new HashMap<>();

    public Calculator(BigDecimal initValue) {
        this.initValue = initValue;
        initMap();
    }

    private void initMap() {
        map.put("add", BigDecimal::add);
        map.put("subtract", BigDecimal::subtract);
        map.put("divide", BigDecimal::divide);
        map.put("multiply", BigDecimal::multiply);
    }

    public void calculate(List<Instruction> instructions) {
        BigDecimal result = initValue;

        for (Instruction instruction : instructions) {
            if (instruction.getValue().equals(BigDecimal.ZERO) && instruction.getInstruction().equals("divide")) {
                throw new ArithmeticException("Cant divide by zero");
            }

            result = map.get(instruction.getInstruction()).apply(result, instruction.getValue());
        }
        System.out.println(result);
    }
}
