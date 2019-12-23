package com.coveros.feedback.event;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = EventPersistenceConfig.class)
@Transactional
class EventMapperIT {

  @Autowired
  private EventMapper eventMapper;

  private final Calendar wednesdayCal = new GregorianCalendar(2020, 0, 8);
  private final Date wednesday = wednesdayCal.getTime();

  private final Calendar thursdayCal = new GregorianCalendar(2020, 0, 9);
  private final Date thursday = thursdayCal.getTime();

  @Test
  void selectEvent() {
    final Event event = eventMapper.selectEvent(1L);

    assertNotNull(event);
    assertEquals(1L, event.getId());
    assertEquals("Building a DevSecOps Pipeline", event.getName());
    assertEquals(wednesday, event.getDate());
  }

  @Test
  void insertEvent() {
    final Event added = new Event(4L, "Digging In: Getting Familiar With The Code To Be A Better Tester", thursday, "Hilary Weaver-Robb");

    eventMapper.insertEvent(added);

    final Event retrieved = eventMapper.selectEvent(4L);
    assertEquals(added, retrieved);
  }

  @Test
  void findAllEvents() {
    final List<Event> allEvents = eventMapper.findAllEvents();

    assertEquals(3, allEvents.size());
  }

  @Test
  void findEvents() {
    final List<Event> thursEvents = eventMapper.findEvents(thursday);

    assertEquals(2, thursEvents.size());
  }

  @Test
  void updateEvent() {
    final Event updated = new Event(1L, "Building an Updated DevSecOps Pipeline", wednesday, null);

    eventMapper.updateEvent(updated);

    final Event retrieved = eventMapper.selectEvent(1L);
    assertEquals(updated, retrieved);
    assertEquals("Building an Updated DevSecOps Pipeline", retrieved.getName());
  }

  @Test
  void deleteEvent() {
    eventMapper.deleteEvent(1L);

    final List<Event> allEvents = eventMapper.findAllEvents();

    assertEquals(2, allEvents.size());
    for (final Event event: allEvents) {
      assertNotEquals(1L, event.getId());
    }
  }

}