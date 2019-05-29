package br.com.ocdev.jornalwordpressapi.ui.activityprincipal;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;
import java.util.Random;

import br.com.ocdev.jornalwordpressapi.Constantes.Constantes;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Categorium;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.Post;
import br.com.ocdev.jornalwordpressapi.Data.Rest.ApiService;
import br.com.ocdev.jornalwordpressapi.Utils.ApiFactory;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class ActivityPrincipalViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private static MutableLiveData<List<Categorium>> CategoriaList;
    public final MutableLiveData<String> categoria = new MutableLiveData();
    private CompositeDisposable disposables = new CompositeDisposable();


    private ApiService api;

    //we will call this method to get the data
    public LiveData<List<Categorium>> getNews() {
        //if the list is null
        loadNews();

        if (CategoriaList == null) {
            CategoriaList = new MutableLiveData<List<Categorium>>();


            //we will load it asynchronously from server in this method
            loadNews();
        }

        return CategoriaList;
    }

    public void loadNews() {

ApiFactory.getRequestApi().getCategoriaBySlug(Constantes.SLUG_NOTICIAS);






            /*  Single<Response<List<Categorium>>> testObservable = ApiFactory.create().getAllCategories();
        testObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<Categorium>>>() {


                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onSuccess(Response<List<Categorium>> value) {
                                   CategoriaList.setValue(value.body());
                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.v("testerro", e.getMessage());
                               }
                           }
                );*/


    }

   /* private Observable<Categorium> getCategoriumObservable() {
        return ApiFactory.getRequestApi()
                .getCategoriaBySlug(Constantes.SLUG_NOTICIAS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<List<Categorium>, ObservableSource<Categorium>>() {
                    @Override
                    public ObservableSource<Categorium> apply(List<Categorium> listResponse) throws Exception {
                        for (int i = 0; i < listResponse.size(); i++) {
                         //   Log.v("teste", listResponse.get(i).getSlug());
                        }

                        return null;
                    }
                });
    }

    private Observable<Categorium> getCategoriesByIDObservable(final Categorium categorium) {
        return ApiFactory.getRequestApi()
                .getCategoriaByParent(categorium.getId())
                .map(new Function<List<Categorium>, Categorium>() {
                    @Override
                    public Categorium apply(List<Categorium> comments) throws Exception {

                        int delay = ((new Random()).nextInt(5) + 1) * 1000; // sleep thread for x ms
                        Thread.sleep(delay);
                        Log.d(TAG, "apply: sleeping thread " + Thread.currentThread().getName() + " for " + String.valueOf(delay) + "ms");

                        return categorium;
                    }
                })
                .subscribeOn(Schedulers.io());

    }*/


}
