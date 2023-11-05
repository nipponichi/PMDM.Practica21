package com.pmdm.practica21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static int suma = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        if (fragment instanceof Fragment1) {
            ((Fragment1) fragment).setOnBtnAddClickListener(onBtnClicked);
        }
    }


    public Fragment1.OnBtnClickedListener onBtnClicked = new Fragment1.OnBtnClickedListener() {
        @Override
        public void onBtnClicked() {
            sumar();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                Bundle bundle = new Bundle();
                bundle.putString("agregar", String.valueOf(suma));
                Fragment2 frag2 = new Fragment2();
                frag2.setArguments(bundle);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainerView2, frag2);
                transaction.commit();
            } else {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtra("agregar", String.valueOf(suma));
                startActivity(i);
            }
        }
    };

    private int sumar() {
        return suma++;
    }
}