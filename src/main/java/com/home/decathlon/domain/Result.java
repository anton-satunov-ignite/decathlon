package com.home.decathlon.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Result {

  private Event event;
  private BigDecimal value;

  @Getter
  @RequiredArgsConstructor
  public enum Event {
    HUNDRED_METERS(Unit.SECOND),
    LONG_JUMP(Unit.METER);

    private final Unit unit;
  }

  public enum Unit {
    METER,
    SECOND
  }

}
