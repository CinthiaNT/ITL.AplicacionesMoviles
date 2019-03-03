package com.example.debug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Integer> numeros = new ArrayList<Integer>();
    private float promedio;
    private float suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeros.add(5);
        numeros.add(6);
        numeros.add(6);
        numeros.add(6);
        numeros.add(6);
        numeros.add(6);
        numeros.add(6);
        for(int i = 0; i<=numeros.size()-1;i++){
            suma = suma + numeros.get(i);
        }
        promedio = suma/numeros.size();
    }
}
