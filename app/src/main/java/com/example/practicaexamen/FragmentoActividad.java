package com.example.practicaexamen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentoActividad extends Fragment {

    TextView textoFragmento;
    Button botonFragmento;
    public FragmentoActividad() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragmento_actividad,
                container, false);
        textoFragmento=v.findViewById(R.id.txtFragment);
        botonFragmento=v.findViewById(R.id.btComprobar);
        botonFragmento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alPulsarBoton(view);
            }
        });
        return v;
    }

    public interface FragmentoInterface{

        public void ComprobarPalabra(String palabra);

    }

    FragmentoInterface manejadorFragmento;

    public void establecerManejador(FragmentoInterface manejador){
        manejadorFragmento=manejador;
    }

    public void alPulsarBoton(View view){
        if(manejadorFragmento!=null){
            manejadorFragmento.ComprobarPalabra(textoFragmento.getText().toString());
        }
    }


}