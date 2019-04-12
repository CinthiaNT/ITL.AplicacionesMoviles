package com.example.directorioapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.directorioapp.Model.Empleado;

public class Fragment_InformacionPersonal extends AppCompatActivity {
    EditText txtNombre,txtapellidoP,txtapellidoM,txtTelefono,txtFechaNa,txtCorreo,txtDireccion,txtEstadoCivil
            ,txtNomina;
    Button btnLaboral,btnPersonal,btnEditar;
    public SQLiteDatabase sqldb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_informacion_personal);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtapellidoP = (EditText)findViewById(R.id.txtApellidoP);
        txtapellidoM =(EditText)findViewById(R.id.txtApellidoM);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtFechaNa = (EditText)findViewById(R.id.txtFechaNa);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtDireccion =(EditText)findViewById(R.id.txtDireccion);
        txtEstadoCivil = (EditText)findViewById(R.id.txtEstadoCivil);
        txtNomina = (EditText)findViewById(R.id.txtNomina);
        btnLaboral=(Button) findViewById(R.id.btnLaboral);
        btnPersonal=(Button) findViewById(R.id.btnPersonal);
        btnEditar=(Button) findViewById(R.id.btnEditar);
        String nominita = getIntent().getExtras().getString("id");
        sqldb = openOrCreateDatabase("directorioDb", Context.MODE_PRIVATE,null);
        mostrarEmpleado();
    }
    public void mostrarEmpleado(){
        Cursor c=sqldb.rawQuery("SELECT nombre,apellidoP,apellidoM,telefono,fechaNacimiento,correo,direccion,estadoCivil,nomina FROM empleado WHERE nomina='"+getIntent().getExtras().getString("id")+"'", null);
        if(c.moveToFirst())
        {
            txtNombre.setText(c.getString(0));
            txtapellidoP.setText(c.getString(1));
            txtapellidoM.setText(c.getString(2));
            txtTelefono.setText(c.getString(3));
            txtFechaNa.setText(c.getString(4));
            txtCorreo.setText(c.getString(5));
            txtDireccion.setText(c.getString(6));
            txtEstadoCivil.setText(c.getString(7));
            txtNomina.setText(c.getString(8));
        }
        else
        {
            showMessage("Error!", "Verifique numero de nomina");
            clearText();
        }
        return;

    }
    public void onClick(View view){
        if(view==btnPersonal) {
            //Cargar Pantalla de datos personales
            mostrarEmpleado();
        } else if(view == btnLaboral){
            //Cargar Pantalla de datos Laborales
            final Intent intent = new Intent(this, Fragment_InformacionLaboral.class);
            intent.putExtra("id",txtNomina.getText().toString());
            this.startActivity(intent);
        } else if(view == btnEditar){
            //Cargar Pantalla de Editar
            final Intent intent = new Intent(this, AgregarEmpleado.class);
            intent.putExtra("id",txtNomina.getText().toString());
            this.startActivity(intent);
        }
    }



    public void showMessage(String title,String message){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
    public void clearText(){
        txtNombre.setText("");
        txtapellidoP.setText("");
        txtapellidoM.setText("");
        txtTelefono.setText("");
        txtFechaNa.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtEstadoCivil.setText("");
        txtNomina.setText("");
    }
}