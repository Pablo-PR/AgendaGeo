package com.example.agendageo.ui.events;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agendageo.R;
import com.example.agendageo.databinding.EventsFragmentBinding;


public class EventsFragment extends Fragment {

    private EventsFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = EventsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerEvent = root.findViewById(R.id.listEvents);

        EventsListAdapter eventsListAdapter = new EventsListAdapter(requireContext());

        recyclerEvent.setAdapter(eventsListAdapter);

        recyclerEvent.setLayoutManager(new LinearLayoutManager(requireContext()));

        EventViewModel eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        eventViewModel.getAllEvents().observe((LifecycleOwner) requireContext(), eventos -> eventsListAdapter.setEvents(eventos));

        return root;
    }
}