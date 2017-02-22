package com.example.jxt0589.javiertovar.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jxt0589.javiertovar.R;
import com.example.jxt0589.javiertovar.util.UtilLog;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.net.URL;


public class ImageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String URL_TO_IMAGE = "param1";
    private static final String IMAGE_SCALE_TYPE = "numb";





    private ImageView imageView;
    private String urlToImage;
    private int scaleType;
    private Bitmap tempBitmap;
    Target target;
    public ImageFragment() {
        // Required empty public constructor

        target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                UtilLog.logD("Image Fragment", "DOONNNENENE");
                tempBitmap = bitmap;
                if(imageView != null) {
                    imageView.setImageBitmap(tempBitmap);
                }
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                UtilLog.logD("Image Fragment", "FAILED to load");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

                UtilLog.logD("Image Fragment", "LOADING");
            }
        };

    }
    // TODO: Rename and change types and number of parameters
    public static ImageFragment newInstance(String urlToImage, int scaleType) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(URL_TO_IMAGE, urlToImage);
        args.putInt(IMAGE_SCALE_TYPE, scaleType);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            urlToImage = getArguments().getString(URL_TO_IMAGE);
            scaleType = getArguments().getInt(IMAGE_SCALE_TYPE);
            Picasso.with(getContext()).load(urlToImage).into(target);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        imageView = (ImageView) view.findViewById(R.id.image_view);
        imageView.setScaleType(ImageView.ScaleType.values()[scaleType]);


        if(tempBitmap != null) {
            imageView.setImageBitmap(tempBitmap);

        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onResume() {
        super.onResume();


    }
}
