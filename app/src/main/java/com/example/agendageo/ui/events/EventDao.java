package com.example.agendageo.ui.events;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {

    @Insert
    void insert(Event event);

    @Query("DELETE FROM events_table")
    void deleteAll();

    @Query("SELECT * FROM events_table ORDER BY fecha DESC")
    LiveData<List<Event>> getAllEvents();
}
