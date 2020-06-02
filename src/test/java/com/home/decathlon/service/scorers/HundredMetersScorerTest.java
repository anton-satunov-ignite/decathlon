package com.home.decathlon.service.scorers;

import static org.assertj.core.api.Assertions.assertThat;

import com.home.decathlon.domain.Result;
import com.home.decathlon.domain.Result.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("HundredMetersScorer")
class HundredMetersScorerTest {

  HundredMetersScorer scorer = new HundredMetersScorer();

  @Nested
  @DisplayName("calculateScore()")
  class CalculateScore {

    @Test
    @DisplayName("should calculate 700 score for 11.756s time")
    void shouldCalculateCorrectScore() {
      final Result result = new Result(Event.HUNDRED_METERS, 11.756);
      assertThat(scorer.calculateScore(result)).isEqualTo(700);
    }

    @Test
    @DisplayName("should calculate 0 score for 18.756s time")
    void shouldCalculateCorrectScore2() {
      final Result result = new Result(Event.HUNDRED_METERS, 18.756);
      assertThat(scorer.calculateScore(result)).isEqualTo(0);
    }

    @Test
    @DisplayName("should calculate 1000 score for 10.395s time")
    void shouldCalculateCorrectScore3() {
      final Result result = new Result(Event.HUNDRED_METERS, 10.395);
      assertThat(scorer.calculateScore(result)).isEqualTo(1000);
    }

    @Test
    @DisplayName("should calculate 1202 score for 9.58s time")
    void shouldCalculateCorrectScore4() {
      final Result result = new Result(Event.HUNDRED_METERS, 9.58);
      assertThat(scorer.calculateScore(result)).isEqualTo(1202);
    }
  }

  @Nested
  @DisplayName("shouldCalculate()")
  class ShouldCalculate {

    @Test
    @DisplayName("should return true on HUNDRED_METERS")
    void shouldReturnTrueOnHundredMeters() {
      assertThat(scorer.shouldCalculate(Event.HUNDRED_METERS)).isTrue();
    }


    @Test
    @DisplayName("should return false on LONG_JUMP")
    void shouldReturnFalseOnLongJump() {
      assertThat(scorer.shouldCalculate(Event.LONG_JUMP)).isFalse();
    }
  }
}