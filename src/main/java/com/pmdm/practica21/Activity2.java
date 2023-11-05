package com.pmdm.practica21;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentTransaction;

public class Activity2 extends AppCompatActivity {

    private String suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        actualizarFragment();
    }

    public void actualizarFragment(){
        suma = getIntent().getStringExtra("agregar");
        Bundle bundle = new Bundle();
        bundle.putString("agregar", suma);
        Fragment2 frag2 = new Fragment2();
        frag2.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, frag2);
        transaction.commit();
    }
}
