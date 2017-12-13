package com.example.jsjos.topmusicdiscoveryapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by jsjos on 12/12/2017.
 */

public class SongFragment extends Fragment {

    private TextView accessView;
    private TextView tokenView;
    private TextView expiresView;
    private TextView stateView;

    @Nullable
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //String access = getArguments().getString(ACCESS_KEY)
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
