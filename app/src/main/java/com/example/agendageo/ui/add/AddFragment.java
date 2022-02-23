package com.example.agendageo.ui.add;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agendageo.R;
import com.example.agendageo.databinding.AddFragmentBinding;
import com.example.agendageo.ui.events.Event;
import com.example.agendageo.ui.events.EventViewModel;

import java.util.Calendar;

public class AddFragment extends Fragment {

    private AddFragmentBinding binding;
    private EditText nombre, latitud, longitud, descripcion;
    private Button button;
    private CalendarView calFecha;

    public static AddFragment newInstance() {
        return new AddFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = AddFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        button = root.findViewById(R.id.button);
        EventViewModel eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);

        calFecha = root.findViewById(R.id.calendarView);
        final long[] nuevaFecha = {0};
        calFecha.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) { Calendar c = Calendar.getInstance();
                c.set(year, month, day);
                nuevaFecha[0] = c.getTimeInMillis();
            } });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Recoger todos los id
                nombre = root.findViewById(R.id.nombre);
                latitud = root.findViewById(R.id.latitud);
                longitud = root.findViewById(R.id.longitud);
                descripcion = root.findViewById(R.id.descripcion);

                if (nombre.getText().toString().length() == 0 || latitud.getText().toString().length() == 0 || longitud.getText().toString().length() == 0 || descripcion.getText().toString().length() == 0) {
                    Toast toast = Toast.makeText(getContext(), "Todos los campos tienen que estar rellenos", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    //Crear evento
                    Event event = new Event(nombre.getText().toString(), nuevaFecha[0], Double.parseDouble(latitud.getText().toString()), Double.parseDouble(longitud.getText().toString()), descripcion.getText().toString());

                    //Insertar el evento en la BBDD
                    eventViewModel.insert(event);
                }
            }
        });
        return root;
    }

}