package com.home.decathlon.service.scorers;

import static com.home.decathlon.domain.Result.Event.HUNDRED_METERS;
import static com.home.decathlon.service.scorers.CalculationUtil.calculateTimeSensitiveScore;

import com.home.decathlon.domain.Result;
import com.home.decathlon.domain.Result.Event;
import com.home.decathlon.service.scorers.CalculationUtil.ScoreCalculationCommand;
import org.springframework.stereotype.Component;

@Component
class HundredMetersScorer implements Scorer {

  private static final ScoreCalculationCommand command = new ScoreCalculationCommand(25.4347, 18.0, 1.81);

  @Override
  public boolean shouldCalculate(Event event) {
    return HUNDRED_METERS.equals(event);
  }

  @Override
  public int calculateScore(Result result) {
    return calculateTimeSensitiveScore(command, result.getValue());
  }

}
