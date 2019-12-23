package com.coveros.feedback.event;

import java.util.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class Event {

  /** Unique identifier for the event */
  private final long id;

  /** Name of the event */
  private final String name;

  /** Date of the event */
  private final Date date;

  /** Description of the event */
  private final String description;

  public Event(final long id, final String name, final Date date, final String description) {
    this.id = id;
    this.name = name;
    this.date = date;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Date getDate() {
    return new Date(date.getTime());
  }

  public String getDescription() {
    return description;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Event)) {
      return false;
    }

    final Event event = (Event) obj;

    return new EqualsBuilder()
        .append(id, event.id)
        .append(name, event.name)
        .append(date, event.date)
        .append(description, event.description)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(-1009, -1013)
        .append(id)
        .append(name)
        .append(date)
        .append(description)
        .toHashCode();
  }
}
