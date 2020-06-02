package com.home.decathlon.controller.resource;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Value;

@Value
public class GetCalculatedScoreResource {

  @NotEmpty
  List<ResultResource> results;

}
