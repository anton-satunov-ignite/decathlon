package com.home.decathlon.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.home.decathlon.controller.resource.CalculatedScoreResource;
import com.home.decathlon.controller.resource.GetCalculatedScoreResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/calculate", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class CalculatorController {

  @PostMapping
  @ResponseStatus(CREATED)
  @ApiOperation(value = "Calculate score for results", httpMethod = "POST")
  public CalculatedScoreResource calculateScoreForResults(
      @ApiParam(required = true) @Valid @RequestBody GetCalculatedScoreResource resource) {
    log.info("Calculating score for results:{}", resource);
    return new CalculatedScoreResource();
  }

}
