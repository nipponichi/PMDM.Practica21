package com.pmdm.practica21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int suma;
    //private int sumaFragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        suma = getIntent().getIntExtra("agregar",suma);
        actualizarFragment2(String.valueOf(suma));
    }

    public void actualizarFragment2(String suma) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
            if (fragment2 != null) {
                fragment2.actualizarValorSuma(suma);
            }
        }
    }
}