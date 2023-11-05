package com.pmdm.practica21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        suma = getIntent().getIntExtra("agregar",suma);
        actualizarFragment2(String.valueOf(suma));
    }

    public void actualizarFragment2(String suma) {
        sumar();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
            if (fragment2 != null) {
                fragment2.actualizarValorSuma(suma);
            }
        } else {
            Intent i = new Intent(this,Activity2.class);
            startActivity(i.putExtra("agregar",String.valueOf(suma)));
        }
    }

    private int sumar() {
        return suma++;
    }
}