package com.home.decathlon.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.home.decathlon.base.BaseUnitTest;
import com.home.decathlon.domain.Result;
import com.home.decathlon.domain.Result.Event;
import com.home.decathlon.service.scorers.Scorer;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@DisplayName("ScoringService")
class ScoringServiceTest extends BaseUnitTest {

  @Mock
  Scorer scorer1;
  @Mock
  Scorer scorer2;

  ScoringService service;

  @BeforeEach
  void setUp() {
    service = spy(new ScoringService(List.of(scorer1, scorer2)));
  }

  @Nested
  @DisplayName("calculateScoreFor()")
  class CalculateScoreFor {

    @Test
    @DisplayName("should call scorers and return right result")
    void shouldCallScorersAndReturnRightResult() {
      final Result result1 = new Result(Event.LONG_JUMP, 22.21);
      final Result result2 = new Result(Event.HUNDRED_METERS, 223.3);
      prepareMocks(scorer1, result1, false, 33);
      prepareMocks(scorer2, result1, true, 10);
      prepareMocks(scorer1, result2, true, 21);

      final int score = service.calculateScoreFor(List.of(result1, result2));
      assertThat(score).isEqualTo(31);
    }

    @Test
    @DisplayName("should throw exception on no scorer found")
    void shouldThrowExceptionOnNoScorerFound() {
      final Result result1 = new Result(Event.LONG_JUMP, 22.0);

      final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
          () -> service.calculateScoreFor(List.of(result1)));
      assertThat(exception.getMessage()).isEqualTo("Scorer not configured for event:LONG_JUMP");
    }

    private void prepareMocks(Scorer scorer, Result result, boolean shouldCalculate, int score) {
      when(scorer.shouldCalculate(result.getEvent())).thenReturn(shouldCalculate);
      if (shouldCalculate) {
        when(scorer.calculateScore(result)).thenReturn(score);
      }
    }
  }
}