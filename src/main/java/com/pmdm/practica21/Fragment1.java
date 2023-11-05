package com.pmdm.practica21;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {

    private Button btnAgr;
    private int suma;

    public void setSuma(int suma) {
        this.suma = suma;
    }


    public Fragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnAgr = view.findViewById(R.id.btnAgregar);
        btnAgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    portraitView();
                } else {
                    landScapeView();
                }
            }
        });
    }

    private void portraitView(){
        actualizarContador();
        Intent i = new Intent(getContext(),Activity2.class);
        startActivity(i.putExtra("agregar",String.valueOf(suma)));
    }

    private void landScapeView(){
        actualizarContador();
    }
    private int sumar() {
        return suma++;
    }

    public void actualizarContador(){
        sumar();
        Bundle bundle = new Bundle();
        bundle.putString("agregar", String.valueOf(suma));
        getParentFragmentManager().setFragmentResult("suma",bundle);
    }
}