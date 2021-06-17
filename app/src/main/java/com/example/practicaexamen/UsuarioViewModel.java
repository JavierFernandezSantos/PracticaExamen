package com.example.practicaexamen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioViewModel extends ViewModel {

    private MutableLiveData<List<Usuario>> datos;

    public LiveData<List<Usuario>> obtenerDatos() {
        if (datos == null) {
            datos = new MutableLiveData<>();
            datos.setValue(new ArrayList<>());
            loadData();
        }
        return datos;
    }

    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioService service = retrofit.create(UsuarioService.class);

        Call<List<Usuario>> peticion = service.listarUsuario();

        peticion.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                datos.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                //Toast.makeText(getApplicationContext(),"Error de red", Toast.LENGTH_LONG).show();
            }
        });
    }
}
