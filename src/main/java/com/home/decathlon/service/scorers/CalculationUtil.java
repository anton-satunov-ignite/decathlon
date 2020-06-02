package com.home.decathlon.service.scorers;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor(access = PRIVATE)
class CalculationUtil {

  static Integer calculateTimeSensitiveScore(ScoreCalculationCommand command, Double result) {
    return calculateScore(command, command.getValueB() - result);
  }

  static Integer calculateDistanceSensitiveScore(ScoreCalculationCommand command, Double result) {
    return calculateScore(command, result - command.getValueB());
  }

  private static Integer calculateScore(ScoreCalculationCommand command, Double result) {
    final double resultAtPowerC = Math.pow(result, command.getValueC());
    return (int) Math.floor(resultAtPowerC * command.getValueA());
  }


  @Value
  public static class ScoreCalculationCommand {

    double valueA;
    double valueB;
    double valueC;
  }

}
