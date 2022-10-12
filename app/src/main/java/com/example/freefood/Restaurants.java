package com.example.freefood;

import android.content.Intent;
import android.os.Bundle;


import android.renderscript.ScriptGroup;
import android.text.style.TabStopSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;

import com.example.freefood.databinding.ActivityMainBinding;
import com.example.freefood.databinding.ActivityTabsBinding;
import com.example.freefood.databinding.FragmentRestaurantsBinding;

import java.util.ArrayList;


public class Restaurants extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       return inflater.inflate(R.layout.fragment_restaurants, container, false);
    }

}