package com.javadiscord.challenge.model.request;

import com.javadiscord.challenge.model.MathOperation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.javadiscord.challenge.model.MathOperation.ADD;
import static com.javadiscord.challenge.model.MathOperation.DIV;
import static com.javadiscord.challenge.model.MathOperation.MUL;
import static com.javadiscord.challenge.model.MathOperation.SUB;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SafeMathRequestTest {

  @Test
  void calculate_add_correctValue() {
    final var input = createMathRequest(ADD, List.of("100", "200", "300"));
    assertEquals(new BigDecimal("600"), input.calculate());
  }

  @Test
  void calculate_sub_correctValue() {
    final var input = createMathRequest(SUB, List.of("50", "20", "10"));
    assertEquals(new BigDecimal("20"), input.calculate());
  }

  @Test
  void calculate_mul_correctValue() {
    final var input = createMathRequest(MUL, List.of("5", "10", "2"));
    assertEquals(new BigDecimal("100"), input.calculate());
  }

  @Test
  void calculate_div_correctValue() {
    final var input = createMathRequest(DIV, List.of("50", "5", "2"));
    assertEquals(new BigDecimal("5"), input.calculate());
  }

  private SafeMathRequest createMathRequest(MathOperation mathOperation, List<String> values) {
    final var mathRequest = new SafeMathRequest();
    mathRequest.setValues(values.stream().map(BigDecimal::new).collect(Collectors.toList()));
    mathRequest.setOperation(mathOperation);
    mathRequest.setType("decimal");
    return mathRequest;
  }
}