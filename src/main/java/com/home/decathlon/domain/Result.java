package com.home.decathlon.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
public class Result {

  Event event;
  double value;

  @Getter
  @RequiredArgsConstructor
  public enum Event {
    HUNDRED_METERS(Unit.SECOND),
    LONG_JUMP(Unit.CENTIMETER);

    private final Unit unit;
  }

  public enum Unit {
    SECOND,
    CENTIMETER
  }

}
