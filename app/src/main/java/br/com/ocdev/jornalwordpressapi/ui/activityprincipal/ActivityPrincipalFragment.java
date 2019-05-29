package br.com.ocdev.jornalwordpressapi.ui.activityprincipal;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Categorium;
import br.com.ocdev.jornalwordpressapi.R;

public class ActivityPrincipalFragment extends Fragment {

    private ActivityPrincipalViewModel mViewModel;

    public static ActivityPrincipalFragment newInstance() {
        return new ActivityPrincipalFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View viewroot = inflater.inflate(R.layout.activity_principal_fragment, container, false);

        return viewroot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ActivityPrincipalViewModel.class);
        ViewModelGetCategorias();
        // TODO: Use the ViewModel
    }


    public void ViewModelGetCategorias() {
        mViewModel.getNews().observe(this, new Observer<List<Categorium>>() {
            @Override
            public void onChanged(@Nullable List<Categorium> responseCategorias) {
                // define an adapter
                for (int i = 0; i < responseCategorias.size(); i++)
                    Log.v("teste", responseCategorias.get(i).getSlug());

            }
        });
    }

}
