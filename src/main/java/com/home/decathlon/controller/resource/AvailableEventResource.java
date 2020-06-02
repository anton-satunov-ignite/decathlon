package com.home.decathlon.controller.resource;

import static com.home.decathlon.domain.Result.Unit;

import com.home.decathlon.domain.Result.Event;
import lombok.Value;

@Value
public class AvailableEventResource {

  Event event;

  public Unit getUnit() {
    return event.getUnit();
  }
}
