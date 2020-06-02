package com.home.decathlon.controller.resource;

import java.util.List;
import lombok.Value;

@Value
public class AvailableEventListResource {

  List<AvailableEventResource> events;

}
