package com.home.decathlon.service.scorers;

import static com.home.decathlon.domain.Result.Event.LONG_JUMP;
import static com.home.decathlon.service.scorers.CalculationUtil.calculateDistanceSensitiveScore;

import com.home.decathlon.domain.Result;
import com.home.decathlon.domain.Result.Event;
import com.home.decathlon.service.scorers.CalculationUtil.ScoreCalculationCommand;
import org.springframework.stereotype.Component;

@Component
class LongJumpScorer implements Scorer {

  private static final ScoreCalculationCommand command = new ScoreCalculationCommand(0.14354, 220, 1.4);

  @Override
  public boolean shouldCalculate(Event event) {
    return LONG_JUMP.equals(event);
  }

  @Override
  public int calculateScore(Result result) {
    return calculateDistanceSensitiveScore(command, result.getValue());
  }
}
