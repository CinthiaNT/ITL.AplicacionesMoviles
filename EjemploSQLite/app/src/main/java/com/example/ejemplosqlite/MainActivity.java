package com.example.ejemplosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ejemplosqlite.modelos.Categoria;

public class MainActivity extends AppCompatActivity {

    Categoria valor_objeto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor_objeto = new Categoria();
        valor_objeto.setNombre_categoria("Clasico");
        valor_objeto.save(this);
        valor_objeto.get(this,1);


    }
}
