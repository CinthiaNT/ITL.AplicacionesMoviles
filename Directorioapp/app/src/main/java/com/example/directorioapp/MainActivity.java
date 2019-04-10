package com.example.directorioapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.directorioapp.Adapter.RVEmpleadoAdapter;
import com.example.directorioapp.Model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RVEmpleadoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       List<Empleado> empleados = new ArrayList<>();
        //Añadimos objetos de tipo "Message" a la lista
        empleados.add(new Empleado("Juana Cinthia", "Nava", "Torres", 15240470));
        empleados.add(new Empleado("Hernán", "Gonzalez", "Alcaraz", 15241051));
        //Instanciamos la vista del recycler view
        recyclerView = findViewById(R.id.rv_empleados);
        //Instanciamos el adapter, poniendole como contexto esta activity y asignadole como lista los mensajes anteriores
        adapter = new RVEmpleadoAdapter(this, empleados);
        //Asignamos el adapter al recyclerview
        recyclerView.setAdapter(adapter);

        //Asignamos el tipo de layout que queramos a nuestro recyclerview, linear, o cuadricula
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
          //recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

    }
}
