package com.pmdm.practica21;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {

    private TextView tv1;

    public Fragment2() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        tv1 = view.findViewById(R.id.txtResultado);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String suma = bundle.getString("agregar", "0");
            actualizarValorSuma(suma);
        } {
            getParentFragmentManager().setFragmentResultListener("suma", this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    String agregar = result.getString("agregar");
                    Toast.makeText(getContext(),"fragment2 Agregar "+agregar, Toast.LENGTH_LONG).show();
                    tv1.setText(agregar);
                }
            });
        }
        return view;
    }
    public void actualizarValorSuma(String suma) {
        tv1.setText(String.valueOf(suma));
    }
}

