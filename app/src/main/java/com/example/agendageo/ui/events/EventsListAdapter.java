package com.example.agendageo.ui.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agendageo.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.ViewHolder>{

    LayoutInflater inflater;
    private List<Event> eventList;

    public EventsListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.event_layout,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        long formatoFecha;

        formatoFecha = Long.parseLong(String.valueOf(eventList.get(position).getFecha()));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String stringFecha = simpleDateFormat.format(new Date(formatoFecha));

        holder.nombre.setText(eventList.get(position).getNombre());
        holder.fecha.setText(stringFecha);
        holder.latitud.setText(String.valueOf(eventList.get(position).getLatitud()) + ",");
        holder.longitud.setText(String.valueOf(eventList.get(position).getLongitud()));
        holder.descripcion.setText(eventList.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        if (eventList != null) {
            return eventList.size();
        }
        else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre, fecha, latitud, longitud, descripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_item);
            fecha = itemView.findViewById(R.id.fecha_item);
            latitud = itemView.findViewById(R.id.latitud_item);
            longitud = itemView.findViewById(R.id.longitud_item);
            descripcion = itemView.findViewById(R.id.descripcion_item);
        }
    }

    public void setEvents(List<Event> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }
}
