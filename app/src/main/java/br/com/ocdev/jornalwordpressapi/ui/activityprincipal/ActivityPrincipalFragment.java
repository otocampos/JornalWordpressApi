package br.com.ocdev.jornalwordpressapi.ui.activityprincipal;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

import br.com.ocdev.jornalwordpressapi.Adapters.RecyclerViewCategoriasAdapter;
import br.com.ocdev.jornalwordpressapi.Adapters.RecyclerViewPostsAdapter;
import br.com.ocdev.jornalwordpressapi.Constantes.Constantes;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Categorium;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.Post;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.PostLite.PostSimple;
import br.com.ocdev.jornalwordpressapi.DetalhesActivity;
import br.com.ocdev.jornalwordpressapi.R;

public class ActivityPrincipalFragment extends Fragment implements RecyclerViewPostsAdapter.OnClickNoticia {

    private ActivityPrincipalViewModel mViewModel;
    private RecyclerView recyclerView, recyclerViewDestaques;
    private RecyclerViewPostsAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static ActivityPrincipalFragment newInstance() {
        return new ActivityPrincipalFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View viewroot = inflater.inflate(R.layout.activity_principal_fragment, container, false);
        recyclerView = (RecyclerView) viewroot.findViewById(R.id.recyclerview_noticias);
        recyclerViewDestaques = (RecyclerView) viewroot.findViewById(R.id.recyclerview_Destaques);
        recyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerViewPostsAdapter(this);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return viewroot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ActivityPrincipalViewModel.class);
        ViewModelGetAllPosts();
        // TODO: Use the ViewModel
    }

    public void ViewModelGetAllPosts() {
        mViewModel.getNews().observe(this, new Observer<List<PostSimple>>() {
            @Override
            public void onChanged(@Nullable List<PostSimple> responsePosts) {
                mAdapter.setCategoriaData(responsePosts);
                recyclerView.setAdapter(mAdapter);
            }
        });
    }


    @Override
    public void getDetalhesNoticias(PostSimple article) {

        Toast.makeText(getActivity(), "teste:" + article.getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), DetalhesActivity.class);
        intent.putExtra("noticia", article);
        startActivity(intent);


    }


}


