package com.example.reto1cabreraalejandro;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewFragment extends Fragment {

    private ImageView imageView;
    private EditText direction;
    private TextView lb1;
    private TextView directionDefined;

    public NewFragment() {
    }
    public static NewFragment newInstance() {
        NewFragment fragment = new NewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Context context = getActivity().getApplicationContext();
        Geocoder geocoder = new Geocoder(context);

        View view = inflater.inflate(R.layout.fragment_new, container, false);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        direction = (EditText) view.findViewById(R.id.direction);
        lb1 = (TextView) view.findViewById(R.id.textView5);
        directionDefined = (TextView) view.findViewById(R.id.textView6);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d = direction.getText().toString();
                List<Address> ds = new ArrayList<Address>();
                if(d!= null){
                    try {
                        ds=geocoder.getFromLocationName(d, 1);
                        direction.setVisibility(EditText.INVISIBLE);
                        lb1.setVisibility(TextView.VISIBLE);
                        directionDefined.setText(ds.get(0).getAddressLine(0));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}