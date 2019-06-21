package br.com.ocdev.jornalwordpressapi.ui.activityprincipal.Detalhes;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.security.Policy;

import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.PostLite.PostSimple;

public class DetalhesViewModel extends ViewModel {



    public final MutableLiveData<PostSimple> detalhesNoticia = new MutableLiveData();


    public void setNoticia(PostSimple post) {
        detalhesNoticia.setValue(post);
    }

    public MutableLiveData<PostSimple> getDetalheNoticia() {

        return detalhesNoticia;
    }












}
