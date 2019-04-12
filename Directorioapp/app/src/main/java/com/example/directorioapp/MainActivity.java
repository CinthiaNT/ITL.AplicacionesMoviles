package com.example.directorioapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.directorioapp.Adapter.RVEmpleadoAdapter;
import com.example.directorioapp.Model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Instancia de BD
    public SQLiteDatabase sqldb;
    private RecyclerView recyclerView;
    private RVEmpleadoAdapter adapter;
    private ArrayList<Empleado> empleados;
    private EditText txtBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBuscar =(EditText)findViewById(R.id.txtBuscar);
        sqldb = openOrCreateDatabase("directorioDb", Context.MODE_PRIVATE,null);
        sqldb.execSQL("create table if not exists empleado(nombre VARCHAR,apellidoP VARCHAR," +
                "apellidoM VARCHAR,telefono VARCHAR,fechaNacimiento VARCHAR," +
                "correo VARCHAR,direccion VARCHAR,estadoCivil VARCHAR," +
                "nomina VARCHAR,curp VARCHAR,rfc VARCHAR," +
                "nss VARCHAR,area VARCHAR, " +
                "puesto VARCHAR,escolaridad VARCHAR," +
                "enfermedades VARCHAR,contacto VARCHAR," +
                "estatus VARCHAR);");
        recyclerView = (RecyclerView) findViewById(R.id.rv_empleados);
        adapter = new RVEmpleadoAdapter(this, obtenerEmpleados());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
    }
    public void agregarEmpleado(View view){
        Intent intent = new Intent(this, AgregarEmpleado.class);
        startActivity(intent);
    }

    public ArrayList<Empleado> obtenerEmpleados() {
        empleados = new ArrayList<>();
        Cursor c = sqldb.rawQuery("SELECT nombre,apellidoP,apellidoM,nomina FROM empleado",null);
        if(c != null && c.getCount()>0){
            c.moveToFirst();
            do{
                empleados.add(new Empleado(c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3)));
            }while (c.moveToNext());
        }
        return empleados;
    }

    public ArrayList<Empleado> filtrarEmpleado(String nombre) {
        //Limpiar la lista
        empleados.clear();
        Cursor c = sqldb.rawQuery("SELECT nombre,apellidoP,apellidoM,nomina from empleados where nombre like '%"+txtBuscar.getText().toString()+"%'", null);
        if(c != null && c.getCount()>0){
            c.moveToFirst();
            do{
                empleados.add(new Empleado(c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3)));
            }while (c.moveToNext());
        }
        return empleados;
    }


    public void showMessage(String title,String message){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(title);
        //alertDialog.setMessage(String.valueOf(empleado.getNo_nomnina()));
        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
