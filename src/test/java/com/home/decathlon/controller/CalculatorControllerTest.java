package com.home.decathlon.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.home.decathlon.base.BaseControllerTest;
import com.home.decathlon.controller.resource.GetCalculatedScoreResource;
import com.home.decathlon.controller.resource.ResultResource;
import com.home.decathlon.domain.Result;
import com.home.decathlon.domain.Result.Event;
import com.home.decathlon.service.ScoringService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@DisplayName("CalculatorController")
@WebMvcTest(controllers = CalculatorController.class)
class CalculatorControllerTest extends BaseControllerTest {

  private static final String BASE_CONTROLLER_PATH = "/calculate";

  @MockBean
  ScoringService scoringService;


  @Nested
  @DisplayName("calculateScoreForResults()")
  class CalculateScoreForResults {

    @Captor
    ArgumentCaptor<List<Result>> argumentCaptor;

    @Test
    @DisplayName("should call service with right value and return right score")
    void shouldCallServiceWithRightValueAndReturnRightScore() throws Exception {
      final ResultResource resultResource = new ResultResource(Event.LONG_JUMP, 10.0);
      when(scoringService.calculateScoreFor(argumentCaptor.capture())).thenReturn(10);

      mockMvc.perform(MockMvcRequestBuilders.post(BASE_CONTROLLER_PATH)
          .contentType(APPLICATION_JSON)
          .content(asJsonString(new GetCalculatedScoreResource(List.of(resultResource)))))
          .andExpect(status().is(201))
          .andExpect(jsonPath("$.score", equalTo(10)));

      final List<Result> value = argumentCaptor.getValue();
      assertThat(value).isEqualTo(List.of(new Result(resultResource.getEvent(), resultResource.getValue())));
    }
  }


  @Nested
  @DisplayName("getAvailableEventsAndUnits()")
  class GetAvailableEventsAndUnits {

    @Test
    @DisplayName("should return available events and units")
    void shouldCallServiceWithRightValueAndReturnRightScore() throws Exception {

      mockMvc.perform(MockMvcRequestBuilders.get(BASE_CONTROLLER_PATH + "/available-events"))
          .andExpect(status().is(200))
          .andExpect(jsonPath("$.events[0].event", equalTo("HUNDRED_METERS")))
          .andExpect(jsonPath("$.events[0].unit", equalTo("SECOND")));

    }
  }
}