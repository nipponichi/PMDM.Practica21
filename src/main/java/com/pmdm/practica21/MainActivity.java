package com.pmdm.practica21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static int suma = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*
        Instancia de Fragment1 donde a través de un casteo, recibimos el resultado de la
        escucha si el botón ha sido pulsado y ejecutamos el codigo dentro del método
     */
    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        if (fragment instanceof Fragment1) {
            ((Fragment1) fragment).setOnBtnAddClickListener(onBtnClicked);
        }
    }

    public Fragment1.OnBtnClickedListener onBtnClicked = new Fragment1.OnBtnClickedListener() {
        @Override
        public void onBtnClicked() {
            //Ejecutamos método del contador
            sumar();

            //Verificamos la orientación del terminal
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                /*
                Si el terminal está en modo landscape, enviamos
                el parámetro al fragment2 al clickar el botón
                */
                Bundle bundle = new Bundle();
                bundle.putString("agregar", String.valueOf(suma));
                Fragment2 frag2 = new Fragment2();
                frag2.setArguments(bundle);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainerView2, frag2);
                transaction.commit();
            } else {
                /*
                Si el terminal está en modo portrait (o no está en modo landscape)
                saltamos a la Activity2 y enviamos el parámetro del contador
                 */
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtra("agregar", String.valueOf(suma));
                startActivity(i);
            }
        }
    };

    //Método donde añadimos +1 al contador
    private int sumar() {
        return suma++;
    }
}