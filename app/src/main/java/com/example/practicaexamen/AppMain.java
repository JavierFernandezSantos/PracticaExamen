package com.example.practicaexamen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppMain extends AppCompatActivity {

    UsuarioViewModel vm;

    AppAdaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listarecycled);

        RecyclerView recyclerView = findViewById(R.id.ListaElementosApi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new AppAdaptador(this);


        recyclerView.setAdapter(adaptador);

        vm = new ViewModelProvider(this).get(UsuarioViewModel.class);


        vm.obtenerDatos().observe(this, new Observer<List<Usuario>>() {
            @Override
            public void onChanged(List<Usuario> pruebas) {
                // Actualizar el UI
                adaptador.addData(new ArrayList(pruebas));
            }
        });







    }
}
