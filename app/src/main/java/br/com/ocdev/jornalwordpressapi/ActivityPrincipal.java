package br.com.ocdev.jornalwordpressapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.ocdev.jornalwordpressapi.ui.activityprincipal.ActivityPrincipalFragment;

public class ActivityPrincipal extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ActivityPrincipalFragment.newInstance())
                    .commitNow();
        }
    }
}
