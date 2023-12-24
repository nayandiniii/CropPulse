package com.example.drawer;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MountainsFragment extends Fragment {
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private List<NewsHeadline> newsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mountains, container, false);
        Button addActivityButton = view.findViewById(R.id.addact);
        addActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the AddFragment
                AddActivity addFragment = new AddActivity();

                // Replace the current fragment with the AddFragment
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, addFragment);
                transaction.addToBackStack(null); // Optional: Add to back stack
                transaction.commit();
            }
        });

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        newsList = new ArrayList<>();

        // Add news headlines to the newsList
        newsList.add(new NewsHeadline("Helping Hands:", "Donation worth $1000", R.drawable.beach2));
        newsList.add(new NewsHeadline("Sponsor a chils:", " Collected money from banaglore for sponsorship program for underprivileged students", R.drawable.beach3));
        newsList.add(new NewsHeadline("Study Well", "Nurture their brain for better future.", R.drawable.beach4));

        adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
