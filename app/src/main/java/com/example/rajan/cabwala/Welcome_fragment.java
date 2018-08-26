package com.example.rajan.cabwala;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.*;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Welcome_fragment extends Fragment {

    TextView myTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_welcome_fragment,container,false);

        TextView myTextView = (TextView) view.findViewById(R.id.slogan);
        Typeface typeface=Typeface.createFromAsset(getActivity().getAssets(), "fonts/concert_one.ttf");
        myTextView.setTypeface(typeface);

        return view;
    }
}
