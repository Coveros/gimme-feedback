package com.coveros.feedback.event;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EventMapper {

  @Select("SELECT * FROM events WHERE id=#{id}")
  Event selectEvent(final long id);

  @Insert("INSERT into events(name, description) VALUES (#{name}, #{description)")
  Event insertEvent(final Event event);

  @Update("UPDATE events SET name=#{name}, description=#{description} WHERE id=#{id}")
  Event updateEvent(final Event event);

  @Delete("DELETE FROM events WHERE id=#{id}")
  Event deleteEvent(final int id);

  @Select("SELECT * FROM events")
  List<Event> findAllEvents();

  @Select("SELECT * FROM events WHERE date=#{date}")
  List<Event> findEvents(final Date date);

}
