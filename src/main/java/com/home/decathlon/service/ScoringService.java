package com.home.decathlon.service;

import com.home.decathlon.domain.Result;
import com.home.decathlon.domain.Result.Event;
import com.home.decathlon.service.scorers.Scorer;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoringService {

  private final List<Scorer> scorers;

  public Integer calculateScoreFor(List<Result> results) {
    return results.stream()
        .map(result -> getScorerFor(result.getEvent()).calculateScore(result))
        .reduce(0, Integer::sum);
  }

  private Scorer getScorerFor(Event event) {
    return scorers.stream()
        .filter(scorer -> scorer.shouldCalculate(event))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Scorer not configured for event:" + event));
  }

}
