package com.home.decathlon.service.scorers;

import static com.home.decathlon.domain.Result.Event.HUNDRED_METERS;

import com.home.decathlon.domain.Result;
import com.home.decathlon.domain.Result.Event;
import org.springframework.stereotype.Component;

@Component
class HundredMetersScorer implements Scorer {

  @Override
  public boolean shouldCalculate(Event event) {
    return HUNDRED_METERS.equals(event);
  }

  @Override
  public Integer calculateScore(Result result) {
    return 2;
  }
}
