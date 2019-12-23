package com.coveros.feedback.event;

import static org.junit.jupiter.api.Assertions.*;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class EventTest {

  @Test
  public void equalsContract() {
    EqualsVerifier.forClass(Event.class).verify();
  }

}