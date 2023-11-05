package com.pmdm.practica21;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {

    private Button btnAgr;
    private OnBtnClickedListener callback;


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
                onBtnAddClick();
            }
        });
    }

    public void setOnBtnAddClickListener(OnBtnClickedListener callback){
        this.callback = callback;
    }

    private void onBtnAddClick(){
        Log.i("Fragment1", "boton pulsado");
        callback.onBtnClicked();
    }

    public interface OnBtnClickedListener {
        public void onBtnClicked();
    }

}
