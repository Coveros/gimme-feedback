package com.coveros.feedback.event;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EventMapper {

  @Select("SELECT * FROM events WHERE id=#{id}")
  Event selectEvent(@Param("id") final long id);

  @Insert("INSERT into events(id, name, date, description) VALUES (#{id}, #{name}, #{date}, #{description})")
  void insertEvent(final Event event);

  @Update("UPDATE events SET name=#{name}, date=#{date}, description=#{description} WHERE id=#{id}")
  void updateEvent(final Event event);

  @Delete("DELETE FROM events WHERE id=#{id}")
  void deleteEvent(final long id);

  @Select("SELECT * FROM events")
  List<Event> findAllEvents();

  @Select("SELECT * FROM events WHERE date=#{date}")
  List<Event> findEvents(final Date date);

}
