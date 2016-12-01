package com.delincuencia.nearbyshop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.delincuencia.nearbyshop.R;
import com.delincuencia.nearbyshop.util.SharedPreferenceHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensajeBienvenida();

    }

    private void mensajeBienvenida(){
        Toast.makeText(this, getResources().getString(R.string.msjBienvenida) + " " +SharedPreferenceHelper.getFirstname(this) +
                " " + SharedPreferenceHelper.getLastname(this), Toast.LENGTH_LONG).show();
    }
}

