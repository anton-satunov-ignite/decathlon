package com.home.decathlon.service.scorers;

import static org.assertj.core.api.Assertions.assertThat;

import com.home.decathlon.domain.Result;
import com.home.decathlon.domain.Result.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LongJumpScorer")
class LongJumpScorerTest {

  LongJumpScorer scorer = new LongJumpScorer();

  @Nested
  @DisplayName("calculateScore()")
  class CalculateScore {

    @Test
    @DisplayName("should calculate 700 score for 651cm time")
    void shouldCalculateCorrectScore() {
      final Result result = new Result(Event.LONG_JUMP, 651.0);
      assertThat(scorer.calculateScore(result)).isEqualTo(700);
    }

    @Test
    @DisplayName("should calculate 0 score for 100cm time")
    void shouldCalculateCorrectScore2() {
      final Result result = new Result(Event.LONG_JUMP, 220.0);
      assertThat(scorer.calculateScore(result)).isEqualTo(0);
    }

    @Test
    @DisplayName("should calculate 1000 score for 776cm time")
    void shouldCalculateCorrectScore3() {
      final Result result = new Result(Event.LONG_JUMP, 776.0);
      assertThat(scorer.calculateScore(result)).isEqualTo(1000);
    }

    @Test
    @DisplayName("should calculate 1312 score for 895cm time")
    void shouldCalculateCorrectScore4() {
      final Result result = new Result(Event.LONG_JUMP, 895.0);
      assertThat(scorer.calculateScore(result)).isEqualTo(1312);
    }
  }

  @Nested
  @DisplayName("shouldCalculate()")
  class ShouldCalculate {

    @Test
    @DisplayName("should return true on LONG_JUMP")
    void shouldReturnTrueOnLongJump() {
      assertThat(scorer.shouldCalculate(Event.LONG_JUMP)).isTrue();
    }


    @Test
    @DisplayName("should return false on HUNDRED_METERS")
    void shouldReturnFalseOnHundredMeters() {
      assertThat(scorer.shouldCalculate(Event.HUNDRED_METERS)).isFalse();
    }
  }
}