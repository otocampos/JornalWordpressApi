package br.com.ocdev.jornalwordpressapi;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import br.com.ocdev.jornalwordpressapi.Adapters.RecyclerViewCategoriasAdapter;
import br.com.ocdev.jornalwordpressapi.Constantes.Constantes;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Categorium;
import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.PostLite.PostSimple;
import br.com.ocdev.jornalwordpressapi.ui.activityprincipal.ActivityPrincipalFragment;
import br.com.ocdev.jornalwordpressapi.ui.activityprincipal.ActivityPrincipalViewModel;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RecyclerViewCategoriasAdapter.OnClickNoticia {
    private BottomSheetBehavior bottomSheetBehavior;
    private ActivityPrincipalViewModel mViewModel;
    private RecyclerView recyclerView;
    private RecyclerViewCategoriasAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Toolbar toolbar;
    int categoriaEscolhida;
    List<Categorium> listadeCategorias;
    private ProgressBar progressBarPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        progressBarPosts = (ProgressBar) findViewById(R.id.progressBarNoticias);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void ViewModelGetCategorias() {
        mViewModel.getCategories(Constantes.SLUG_NOTICIAS).observe(this, new Observer<List<Categorium>>() {
            @Override
            public void onChanged(@Nullable List<Categorium> responseCategorias) {
                mAdapter.setCategoriaData(responseCategorias);
                recyclerView.setAdapter(mAdapter);
                listadeCategorias = responseCategorias;
                ViewModelGetAllPosts();
                toolbar.setTitle("teste");
                /*if (responseCategorias !=null) {
                    toolbar.setTitle(responseCategorias.get(mViewModel.getPosicaoCategoria().getValue()).getSlug());
                }*/
            }

        });
    }



    public void ViewModelGetAllPosts() {
        mViewModel.getNews().observe(this, new Observer<List<PostSimple>>() {
            @Override
            public void onChanged(@Nullable List<PostSimple> responsePosts) {
                Log.v("categoriaescolhida", String.valueOf(categoriaEscolhida));
                toolbar.setTitle(listadeCategorias.get(categoriaEscolhida).getName());
                progressBarPosts.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public void getDetalhesNoticias(Categorium article, int position) {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        ViewModelGetAllPosts();
        progressBarPosts.setVisibility(View.VISIBLE);
        categoriaEscolhida = position;
        Log.v("posicao", String.valueOf(position));
        mViewModel.setMessageCategoria(article.getId());
        mViewModel.loadPostsByCategory();
        // Toast.makeText(this, article.getName(), Toast.LENGTH_SHORT).show();

    }


}
