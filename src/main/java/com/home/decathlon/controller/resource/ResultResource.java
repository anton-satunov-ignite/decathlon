package com.home.decathlon.controller.resource;

import com.home.decathlon.domain.Result.Event;
import javax.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ResultResource {

  @NotNull
  Event event;

  @NotNull
  Double value;

}
