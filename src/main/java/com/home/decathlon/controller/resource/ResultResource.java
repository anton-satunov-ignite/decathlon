package com.home.decathlon.controller.resource;

import com.home.decathlon.domain.Result.Event;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResource {

  @NotNull
  private Event event;

  @NotNull
  private BigDecimal value;

}
