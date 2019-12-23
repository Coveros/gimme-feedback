package com.coveros.feedback.collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class EventRestController {

  @Autowired
  private EventMapper eventMapper;

  public Event getEvent(@RequestParam(value="id") long id) {
    return null;
  }

}

