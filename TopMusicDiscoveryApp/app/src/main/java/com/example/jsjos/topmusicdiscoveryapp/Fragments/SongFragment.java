package com.example.jsjos.topmusicdiscoveryapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jsjos.topmusicdiscoveryapp.R;

import org.w3c.dom.Text;

/**
 * Created by jsjos on 12/12/2017.
 */

public class SongFragment extends Fragment {

    private TextView artistNameTV;
    private TextView albumNameTV;
    private TextView songNameTV;

    @Nullable
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //String access = getArguments().getString(ACCESS_KEY)
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.song_fragment_layout, container, false);

        this.artistNameTV = v.findViewById(R.id.tv_artist_name);
        this.albumNameTV = v.findViewById(R.id.tv_album_name);
        this.songNameTV = v.findViewById(R.id.tv_song_name);

        return v;
    }
}
