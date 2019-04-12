package com.example.directorioapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.directorioapp.Adapter.RVEmpleadoAdapter;
import com.example.directorioapp.Model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Instancia de BD
    public SQLiteDatabase sqldb;
    private RecyclerView recyclerView;
    private RVEmpleadoAdapter adapter;
    private ArrayList<Empleado> empleadosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqldb = openOrCreateDatabase("directorioDb", Context.MODE_PRIVATE,null);
        sqldb.execSQL("create table if not exists empleado(nombre VARCHAR,apellidoP VARCHAR,apellidoM VARCHAR,telefono VARCHAR,fechaNacimiento VARCHAR,correo VARCHAR,direccion VARCHAR,estadoCivil VARCHAR,nomina VARCHAR,curp VARCHAR,rfc VARCHAR,nss VARCHAR,area VARCHAR, puesto VARCHAR,escolaridad VARCHAR,enfermedades VARCHAR,contacto VARCHAR,estatus VARCHAR);");
       List<Empleado> empleados = new ArrayList<>();
        //Añadimos objetos de tipo "Message" a la lista
        //empleados.add(new Empleado("Juana Cinthia", "Nava", "Torres", 15240470));
       // empleados.add(new Empleado("Hernán", "Gonzalez", "Alcaraz", 15241051));
        //Instanciamos la vista del recycler view
        recyclerView = (RecyclerView) findViewById(R.id.rv_empleados);
        //Instanciamos el adapter, poniendole como contexto esta activity y asignadole como lista los mensajes anteriores
        adapter = new RVEmpleadoAdapter(this, empleados);
        //Asignamos el adapter al recyclerview
        recyclerView.setAdapter(adapter);

        //Asignamos el tipo de layout que queramos a nuestro recyclerview, linear, o cuadricula
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
          //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }
    public void agregarEmpleado(View view){
        Intent intent = new Intent(this, AgregarEmpleado.class);
        startActivity(intent);
    }
    public void insertar(Empleado e){
        showMessage("Exito!",e.getNombre());
        sqldb.execSQL("INSERT INTO empleado VALUES('"+e.getNombre()+"','"+e.getApellido_p()+"','"+e.getApellido_m()+"','"+
                e.getTelefono()+"','"+e.getFecha_nacimiento()+"','"+e.getCorreo()+"','"+e.getDireccion()+"','"+e.getEstado_civil()+"','"
                +e.getNo_nomnina()+"','"+e.getCurp()+"','"+e.getRfc()+"','"+e.getNss()+"','"+e.getArea()+"','"+e.getPuesto()+"','"+
                e.getEscolaridad()+"','"+e.getEnfermedades_cronicas()+"','"+e.getContacto_emergencia()+"','"+e.getEstatus()+"');");
        showMessage("Exito!","Empleado registrado con exito");
        return;
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
