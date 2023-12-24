package com.example.drawer;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BeachFragment extends Fragment {

    ImageView mountImg;
    ImageView mountImg2;
    ImageView mountImg3;
    ImageView mountImg4;
    ImageView mountImg5;
    ImageView mountImg6;
    ImageView mountImg7;
    ImageView mountImg8;


    TextView mountName;

    public BeachFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beach, container, false);
        mountImg = view.findViewById(R.id.beach1);
        mountImg2 = view.findViewById(R.id.beach2);
        mountImg3 = view.findViewById(R.id.beach3);
        mountImg4 = view.findViewById(R.id.beach4);
        mountImg5 = view.findViewById(R.id.beach5);
        mountImg6 = view.findViewById(R.id.beach6);
        mountImg7 = view.findViewById(R.id.beach7);


        mountImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = "Kudle Beach is also located in Gokarna and is best for tourists who like to spend some time alone with themselves. The ambience of this beach is quite serene and tranquil which offers unmatched peace of mind.";
                showDialog(text, mountImg);
            }
        });
        mountImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = "Paradise beach is located in Gokarna, There are several adventurous activities that you can take part in when visiting the beach. Sport events as well as sailing are some of the amazing and exciting things you can be a part of.\n";
                showDialog(text, mountImg2);
            }
        });
        mountImg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = "Tannirbhavi beach is located in Mangalore and is white clean and well maintained. It has lush green trees at some distance which complement the blue water of the sea perfectly.";
                showDialog(text, mountImg3);
            }
        });

        mountImg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = "This beach is located in Gokarna and is quite an attractive tourist spot. This place is unreachable by road. You would have to hike to get to Half Moon beach or you can take motorboats available from Om Beach.";
                showDialog(text, mountImg4);
            }
        });

        mountImg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = "Malpe Beach coastal area is located about 6 kilometres away from Udupi and is perfect for a holiday with friends and family. It offers the perfect view of St. Mary’s Island and it looks extremely beautiful since this place has not been exploited by commercial tourism.";
                showDialog(text, mountImg5);
            }
        });
        mountImg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = "This spectacular beach is located next to the Kasarkod village and is a certified blue flag beach. It is clean and very well maintained. It has one of the most brilliant views of the sea in Karnataka.";
                showDialog(text, mountImg6);
            }
        });
        mountImg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = "This coastal front is located in Udupi and is another one of the blue flag beaches. The reflection of the deep blue sky on the water creates an adventurous and thrilling environment.";
                showDialog(text, mountImg7);

            }
        });


        return view;
    }

    private void showDialog(String mountText, ImageView imageView) {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheet);
        dialog.show();

        mountName = dialog.findViewById(R.id.bottomSheetTextView);
        mountImg = dialog.findViewById(R.id.bottomSheetImage);

        mountName.setText(mountText);
        mountImg.setImageDrawable(imageView.getDrawable());

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}
