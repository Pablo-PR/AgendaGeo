package com.example.agendageo.ui.events;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.agendageo.EventRoomDatabase;

import java.util.List;

public class EventRepository {
    private EventDao eventDao;
    private LiveData<List<Event>> allEvents;

    EventRepository(Application application) {
        EventRoomDatabase db = EventRoomDatabase.getDatabase(application);
        eventDao = db.eventDao();
        allEvents = eventDao.getAllEvents();
    }

    LiveData<List<Event>> getAllEvents() {
        return allEvents;
    }

    public void insert (Event event) {
        new insertAsyncTask(eventDao).execute(event);
    }

    private static class insertAsyncTask extends AsyncTask<Event, Void, Void> {

        private EventDao mAsyncTaskDao;

        insertAsyncTask(EventDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Event... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
