package com.home.decathlon.controller.resource;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCalculatedScoreResource {

  @NotEmpty
  private List<ResultResource> results;

}
