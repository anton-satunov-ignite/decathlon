package com.home.decathlon.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.home.decathlon.controller.resource.CalculatedScoreResource;
import com.home.decathlon.controller.resource.GetCalculatedScoreResource;
import com.home.decathlon.domain.Result;
import com.home.decathlon.service.ScoringService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.stream.Collectors;
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

  private final ScoringService scoringService;

  @PostMapping
  @ResponseStatus(CREATED)
  @ApiOperation(value = "Calculate score for results", httpMethod = "POST")
  public CalculatedScoreResource calculateScoreForResults(
      @ApiParam(required = true) @Valid @RequestBody GetCalculatedScoreResource resource) {
    log.info("Calculating score for results:{}", resource);

    final List<Result> results = mapToDomainList(resource);
    return new CalculatedScoreResource(scoringService.calculateScoreFor(results));
  }

  private List<Result> mapToDomainList(GetCalculatedScoreResource resource) {
    return resource.getResults().stream()
        .map(resultResource -> new Result(resultResource.getEvent(), resultResource.getValue()))
        .collect(Collectors.toList());
  }

}
