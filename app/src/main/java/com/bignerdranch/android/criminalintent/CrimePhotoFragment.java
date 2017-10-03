package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Jerry on 2017/10/3.
 */

public class CrimePhotoFragment extends DialogFragment {

    private static final String PHOTO_PATH = "photopath";

    private ImageView mPhotoImageView;

    public static CrimePhotoFragment newInstance(String path) {
        Bundle args = new Bundle();
        args.putString(PHOTO_PATH, path);
        CrimePhotoFragment fragment = new CrimePhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String photoPath = getArguments().getString(PHOTO_PATH);
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_photo);

        ImageView crimePhoto = (ImageView) dialog.findViewById(R.id.dialog_crime_photo);

        crimePhoto.setImageBitmap(PictureUtils.getScaledBitmap(photoPath, getActivity()));

        crimePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        return dialog;
    }
}
