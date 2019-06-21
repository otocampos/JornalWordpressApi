package br.com.ocdev.jornalwordpressapi;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.PostLite.PostSimple;
import br.com.ocdev.jornalwordpressapi.databinding.ActivityDetalhesBinding;
import br.com.ocdev.jornalwordpressapi.ui.activityprincipal.Detalhes.DetalhesViewModel;

public class DetalhesActivity extends AppCompatActivity {
    PostSimple postSimple;
    DetalhesViewModel mViewModel;
    ActivityDetalhesBinding contentDetalhesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        /*getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*/
        mViewModel = ViewModelProviders.of(this).get(DetalhesViewModel.class);
        if (savedInstanceState == null) {
            postSimple = getIntent().getParcelableExtra("noticia");
            mViewModel.setNoticia(postSimple);
        }
        contentDetalhesBinding = DataBindingUtil.setContentView(this, R.layout.activity_detalhes);

        setSupportActionBar(contentDetalhesBinding.toolbar);

        mViewModel.getDetalheNoticia().observe(this, new Observer<PostSimple>() {
            @Override
            public void onChanged(@Nullable PostSimple postSimple) {
                contentDetalhesBinding.setNews(postSimple);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
