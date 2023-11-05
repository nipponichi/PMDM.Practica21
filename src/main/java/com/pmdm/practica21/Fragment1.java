package com.pmdm.practica21;

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
    //Objeto callback de tipo OnBtnClickedListener (interface)
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

    //Llama al método onBtnClicked() desde el objeto callback
    private void onBtnAddClick(){
        callback.onBtnClicked();
    }

    //Interface con metodo a sobreescribir
    public interface OnBtnClickedListener {
        public void onBtnClicked();
    }
}
