package com.example.jsjos.topmusicdiscoveryapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.jsjos.topmusicdiscoveryapp.Fragments.SongFragment;
import com.example.jsjos.topmusicdiscoveryapp.R;

/**
 * Created by jsjos on 12/12/2017.
 */

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_view_layout);

        //showFrag(SongFragment);

    }

    public void showFrag(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_fragment_container, fragment)
                .commit();

    }
}
