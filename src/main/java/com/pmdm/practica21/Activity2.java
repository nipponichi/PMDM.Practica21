package com.pmdm.practica21;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;

public class Activity2 extends AppCompatActivity {

    private String suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toast.makeText(this, "activity2", Toast.LENGTH_SHORT).show();
        actualizarFragment();
    }

    public void actualizarFragment(){
        suma = getIntent().getStringExtra("agregar");
        Log.i("suma Activity2",suma);
        Bundle bundle = new Bundle();
        bundle.putString("agregar", suma);
        Fragment2 frag2 = new Fragment2();
        frag2.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, frag2);
        transaction.commit();
    }
}
