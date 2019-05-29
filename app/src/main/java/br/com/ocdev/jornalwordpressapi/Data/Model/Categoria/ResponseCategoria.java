package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseCategoria {

    @SerializedName("articles")
    @Expose
    private List<Categorium> categorias = null;


}
