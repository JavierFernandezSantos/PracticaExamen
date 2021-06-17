package com.example.practicaexamen;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface UsuarioService {

    @GET("https://60c7248306f3160017d28965.mockapi.io/Usuario")
    Call<List<Usuario>> listarUsuario();


}
