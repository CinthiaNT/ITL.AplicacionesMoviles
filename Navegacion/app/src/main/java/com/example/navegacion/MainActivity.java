package com.example.navegacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Empleado empleado;

    public void activity2(View view){
        empleado = new Empleado("Cinthia","Nava",21);
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("empleado",empleado);
        startActivity(intent);
    }

}
