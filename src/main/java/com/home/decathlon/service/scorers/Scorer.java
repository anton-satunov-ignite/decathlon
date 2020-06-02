package com.home.decathlon.service.scorers;

import com.home.decathlon.domain.Result;
import com.home.decathlon.domain.Result.Event;

public interface Scorer {

  boolean shouldCalculate(Event event);

  int calculateScore(Result result);

}
