package com.home.decathlon.controller.resource;

import java.util.List;
import lombok.Data;

@Data
public class GetCalculatedScoreResource {

  private List<ResultResource> results;

}
