package com.example.drawer;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        VideoView videoView = view.findViewById(R.id.videoView);

        // Set the video file from the resources
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.help;
        videoView.setVideoURI(Uri.parse(videoPath));



        // Start playing the video
        videoView.start();

        return view;
    }
}
