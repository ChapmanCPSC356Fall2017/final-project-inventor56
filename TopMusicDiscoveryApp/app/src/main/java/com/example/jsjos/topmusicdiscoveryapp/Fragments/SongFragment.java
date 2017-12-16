package com.example.jsjos.topmusicdiscoveryapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.Track;
import com.example.jsjos.topmusicdiscoveryapp.R;

import org.w3c.dom.Text;

public class SongFragment extends Fragment {

    private TextView rankingTV;

    private TextView artistNameTV;
    private TextView albumNameTV;
    private TextView songNameTV;

    private Track track;
    private String ranking = "#";

    private final String DEBUGLOG = "Song Fragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        track = (Track) getArguments().getSerializable("TrackObj"); // Set the specific track for this fragment
        ranking += (getArguments().getInt("Ranking")+1);

        //String access = getArguments().getString(ACCESS_KEY)
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.song_fragment_layout, container, false);


        this.rankingTV = v.findViewById(R.id.tv_number_ranking);
        this.artistNameTV = v.findViewById(R.id.tv_artist_name);
        this.albumNameTV = v.findViewById(R.id.tv_album_name);
        this.songNameTV = v.findViewById(R.id.tv_song_name);


        Log.e(DEBUGLOG, "So we are in the song fragment");

        rankingTV.setText(ranking);
        Log.e(DEBUGLOG, "So we " + ranking);
        songNameTV.setText(track.getTrackName());
        artistNameTV.setText(track.getArtistNames());
        albumNameTV.setText(track.getAlbumName());

        return v;
    }
}
