package com.pmdm.practica21;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        //Recibimos los parámetros desde el objeto bundle
        Bundle bundle = getArguments();

        /*
        Si bundle tiene valor utiliza la clave "agregar" para añadir el valor del String proveniente
        desde MainActivity o Activity2
         */
        if (bundle != null) {
            String suma = bundle.getString("agregar", "0");
            actualizarValorSuma(suma);
        }
        return view;
    }

    //Pasamos el valor a txtResultado de la vista de Fragment2 a traves del objeto tv1
    public void actualizarValorSuma(String suma) {
        tv1.setText(String.valueOf(suma));
    }
}

