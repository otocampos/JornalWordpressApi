package br.com.ocdev.jornalwordpressapi.Data.Rest;


import java.util.List;

import br.com.ocdev.jornalwordpressapi.Constantes.Constantes;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Categorium;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    //Retorna a lista de todas as categorias
    @GET(Constantes.CATEGORIES)
    Single<Response<List<Categorium>>> getAllCategories();


    @GET(Constantes.CATEGORIES)
    Single<Response<List<Categorium>>> getCategoriaBySlug(@Query(Constantes.CATEGORY_BY_SLUG) String slug);

/*
    @GET(Constantes.CATEGORIES)
    Observable<List<Categorium>> getCategoriaBySlug(@Query(Constantes.CATEGORY_BY_SLUG) String slug);*/

    @GET(Constantes.CATEGORIES)
    Observable<List<Categorium>> getCategoriaByParent(@Query(Constantes.CATEGORY_BY_PARENT) int parent);


}
