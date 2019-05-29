package br.com.ocdev.jornalwordpressapi.Utils;

import br.com.ocdev.jornalwordpressapi.Constantes.Constantes;
import br.com.ocdev.jornalwordpressapi.Data.Rest.ApiService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(Constantes.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static ApiService apiService = retrofit.create(ApiService.class);

    public static ApiService getRequestApi() {
        return apiService;
    }


}
