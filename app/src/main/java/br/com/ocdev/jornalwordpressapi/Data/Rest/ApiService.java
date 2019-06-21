package br.com.ocdev.jornalwordpressapi.Data.Rest;


import android.util.Log;

import java.util.List;

import br.com.ocdev.jornalwordpressapi.Constantes.Constantes;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Categorium;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.Post;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.PostLite.PostSimple;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    //Retorna a lista de todas as categorias
    @GET(Constantes.URL_API_DEFAULT + Constantes.CATEGORIES)
    Single<Response<List<Categorium>>> getAllCategories();


   /* @GET(Constantes.CATEGORIES)
    Single<Response<List<Categorium>>> getCategoriaBySlug(@Query(Constantes.CATEGORY_BY_SLUG) String slug);*/


    @GET(Constantes.URL_API_DEFAULT + Constantes.CATEGORIES)
    Observable<List<Categorium>> getCategoriaBySlug(@Query(Constantes.CATEGORY_BY_SLUG) String slug);

    @GET(Constantes.URL_API_DEFAULT + Constantes.CATEGORIES)
    Observable<List<Categorium>> getCategoriaByParent(@Query(Constantes.CATEGORY_BY_PARENT) int parent);

    @GET(Constantes.URL_API_PLUGIN +Constantes.POSTS + "?" + Constantes.POSTS_POR_PAGINA + "=" + Constantes.CINQUENTA_POSTS)
    Single<Response<List<PostSimple>>> getAllPosts();

    @GET(Constantes.URL_API_PLUGIN + Constantes.POSTS + "?" + Constantes.POSTS_POR_PAGINA + "=" + Constantes.CINQUENTA_POSTS)
    Single<Response<List<PostSimple>>> getAllPostsByCategory(@Query(Constantes.CATEGORY) Integer categoriaId);


}

