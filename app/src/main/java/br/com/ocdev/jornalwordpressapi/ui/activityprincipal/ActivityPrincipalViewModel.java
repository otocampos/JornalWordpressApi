package br.com.ocdev.jornalwordpressapi.ui.activityprincipal;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import br.com.ocdev.jornalwordpressapi.Constantes.Constantes;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Categorium;
import br.com.ocdev.jornalwordpressapi.Data.Rest.ApiService;
import br.com.ocdev.jornalwordpressapi.Utils.ApiFactory;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ActivityPrincipalViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private static MutableLiveData<List<Categorium>> CategoriaList;
    public final MutableLiveData<String> categoria = new MutableLiveData();
    private CompositeDisposable disposables = new CompositeDisposable();


    private ApiService api;

    //we will call this method to get the data
    public LiveData<List<Categorium>> getCategories(String CategoriaPai) {
        //if the list is null


        if (CategoriaList == null) {
            CategoriaList = new MutableLiveData<List<Categorium>>();


            //we will load it asynchronously from server in this method
            LoadCategories(CategoriaPai);
        }

        return CategoriaList;
    }

    public void loadNews() {



    }


    public void LoadCategories(String CategoriaPai) {
        streamFetchUserFollowingAndFetchFirstUserInfos(CategoriaPai).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<List<Categorium>>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Categorium> value) {
                        CategoriaList.setValue(value);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    // 1 - Create a stream that will get user infos on Github API
    public static Observable<List<Categorium>> streamFetchCategoryInfos(int categoriaID) {
        return ApiFactory.getRequestApi().getCategoriaByParent(categoriaID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);

    }

    // 2 - Create a stream that will :
    //     A. Fetch all users followed by "username"
    //     B. Return the first user of the list
    //     C. Fetch details of the first user
    public static Observable<List<Categorium>> streamFetchUserFollowingAndFetchFirstUserInfos(String categoriaPai) {
        return streamFetchUserFollowing(categoriaPai) // A.
                .map(new Function<List<Categorium>, Categorium>() {
                    @Override
                    public Categorium apply(List<Categorium> users) throws Exception {
                        Log.v("teste", users.get(0).getName());
                        return users.get(0); // B.
                    }
                })
                .flatMap(new Function<Categorium, Observable<List<Categorium>>>() {
                    @Override
                    public Observable<List<Categorium>> apply(Categorium user) throws Exception {
                        // C.
                        Log.v("teste", user.getName());

                        return streamFetchCategoryInfos(user.getId());
                    }
                });
    }

    public static Observable<List<Categorium>> streamFetchUserFollowing(String categoriaPai) {
        Log.v("teste", categoriaPai);
        return ApiFactory.getRequestApi().getCategoriaBySlug(categoriaPai)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);

    }


}
















