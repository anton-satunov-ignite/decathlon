package com.home.decathlon.service.scorers;

import static com.home.decathlon.domain.Result.Event.LONG_JUMP;

import com.home.decathlon.domain.Result;
import com.home.decathlon.domain.Result.Event;
import org.springframework.stereotype.Component;

@Component
class LongJumpScorer implements Scorer {

  @Override
  public boolean shouldCalculate(Event event) {
    return LONG_JUMP.equals(event);
  }

  @Override
  public Integer calculateScore(Result result) {
    return 1;
  }
}
