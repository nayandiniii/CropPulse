package com.example.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.drawer.AboutFragment;
import com.example.drawer.R;

public class SelectFragment extends Fragment {
    ImageButton button1;
    ImageButton button2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_select, container, false);

        button1 = rootView.findViewById(R.id.mountains);
        button2 = rootView.findViewById(R.id.beach);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the AboutFragment
                MountainsFragment  mountainsFragment = new MountainsFragment();

                // Replace the current fragment with the AboutFragment
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, mountainsFragment);
                transaction.addToBackStack(null); // Optional: Add to back stack
                transaction.commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the AboutFragment
                BeachFragment  BeachFragment = new BeachFragment();

                // Replace the current fragment with the AboutFragment
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, BeachFragment);
                transaction.addToBackStack(null); // Optional: Add to back stack
                transaction.commit();
            }
        });

        return rootView;
    }
}
