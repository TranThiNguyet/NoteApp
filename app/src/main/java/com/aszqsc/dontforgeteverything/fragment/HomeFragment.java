package com.aszqsc.dontforgeteverything.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aszqsc.dontforgeteverything.LoginActivity;
import com.aszqsc.dontforgeteverything.R;
import com.aszqsc.dontforgeteverything.RegisterActivity;
import com.aszqsc.dontforgeteverything.model.MyDatabaseHelper;

public class HomeFragment extends Fragment {
    MyDatabaseHelper db;
    Button btnLogout;

    public HomeFragment(MyDatabaseHelper db) {
        super();
        this.db = db;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frament_homee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), LoginActivity.class);
                startActivity(i);
            }
        });
    }


}
