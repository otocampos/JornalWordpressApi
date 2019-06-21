package br.com.ocdev.jornalwordpressapi;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import br.com.ocdev.jornalwordpressapi.Adapters.RecyclerViewCategoriasAdapter;
import br.com.ocdev.jornalwordpressapi.Constantes.Constantes;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Categorium;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.Post;
import br.com.ocdev.jornalwordpressapi.ui.activityprincipal.ActivityPrincipalFragment;
import br.com.ocdev.jornalwordpressapi.ui.activityprincipal.ActivityPrincipalViewModel;

public class ActivityPrincipal extends AppCompatActivity implements RecyclerViewCategoriasAdapter.OnClickNoticia {
    private BottomSheetBehavior bottomSheetBehavior;
    private ActivityPrincipalViewModel mViewModel;
    private RecyclerView recyclerView;
    private RecyclerViewCategoriasAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Toolbar toolbar;
    int categoriaEscolhida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_activity);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerViewCategoriasAdapter(this);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setPeekHeight(120);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ActivityPrincipalFragment.newInstance())
                    .commitNow();
        }
        mViewModel = ViewModelProviders.of(this).get(ActivityPrincipalViewModel.class);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });


        ViewModelGetCategorias();
    }

    public void ViewModelGetCategorias() {
        mViewModel.getCategories(Constantes.SLUG_NOTICIAS).observe(this, new Observer<List<Categorium>>() {
            @Override
            public void onChanged(@Nullable List<Categorium> responseCategorias) {
                mAdapter.setCategoriaData(responseCategorias);
                recyclerView.setAdapter(mAdapter);
                toolbar.setTitle(responseCategorias.get(getCategoriaEscolhida()).getSlug());
            }
        });
    }


    @Override
    public void getDetalhesNoticias(Categorium article, int position) {
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        setCategoriaEscolhida(position);
        //Log.v("posicao", String.valueOf(position));
        mViewModel.setMessageCategoria(article.getId());
        mViewModel.loadPostsByCategory();
        Toast.makeText(this, article.getName(), Toast.LENGTH_SHORT).show();

    }

    public int getCategoriaEscolhida() {
        return categoriaEscolhida;
    }

    public void setCategoriaEscolhida(int categoriaEscolhida) {
        this.categoriaEscolhida = categoriaEscolhida;
    }
}
