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

public class Fragment_InformacionLaboral  extends AppCompatActivity {
    EditText txtNomina,txtCurp,txtRfc,txtNss,txtArea,txtPuesto,txtEscolaridad,txtEnfermedadesCronicas,
            txtContactoEmergencia,txtEstatus;
    Button btnLaboral,btnPersonal,btnEditar;
    public SQLiteDatabase sqldb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_informacion_empleo);
        txtNomina =(EditText)findViewById(R.id.txtNomina);
        txtCurp = (EditText)findViewById(R.id.txtCurp);
        txtRfc=(EditText)findViewById(R.id.txtRfc);
        txtNss=(EditText)findViewById(R.id.txtNss);
        txtArea=(EditText)findViewById(R.id.txtArea);
        txtPuesto=(EditText)findViewById(R.id.txtPuesto);
        txtEscolaridad=(EditText)findViewById(R.id.txtEscolaridad);
        txtEnfermedadesCronicas=(EditText)findViewById(R.id.txtEnfermedadesCronicas);
        txtContactoEmergencia=(EditText)findViewById(R.id.txtContactoEmergencia);
        txtEstatus=(EditText)findViewById(R.id.txtEstatus);
        btnLaboral=(Button) findViewById(R.id.btnLaboral);
        btnPersonal=(Button) findViewById(R.id.btnPersonal);
        btnEditar=(Button) findViewById(R.id.btnEditar);
        sqldb = openOrCreateDatabase("directorioDb", Context.MODE_PRIVATE,null);
        mostrarEmpleado();
    }
    public void mostrarEmpleado(){
        Cursor c=sqldb.rawQuery("SELECT nomina,curp,rfc,nss,area,puesto,escolaridad,enfermedades,contacto,estatus FROM empleado WHERE nomina='"+getIntent().getExtras().getString("id")+"'", null);
        if(c.moveToFirst())
        {
            txtNomina.setText(c.getString(0));
            txtCurp.setText(c.getString(1));
            txtRfc.setText(c.getString(2));
            txtNss.setText(c.getString(3));
            txtArea.setText(c.getString(4));
            txtPuesto.setText(c.getString(5));
            txtEscolaridad.setText(c.getString(6));
            txtEnfermedadesCronicas.setText(c.getString(7));
            txtContactoEmergencia.setText(c.getString(8));
            txtEstatus.setText(c.getString(9));
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
            final Intent intent = new Intent(this, Fragment_InformacionPersonal.class);
            intent.putExtra("id",txtNomina.getText().toString());
            this.startActivity(intent);
        } else if(view == btnLaboral){
            //Cargar Pantalla de datos Laborales
            mostrarEmpleado();
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
        txtNomina.setText("");
        txtCurp.setText("");
        txtRfc.setText("");
        txtNss.setText("");
        txtArea.setText("");
        txtPuesto.setText("");
        txtEscolaridad.setText("");
        txtEnfermedadesCronicas.setText("");
        txtContactoEmergencia.setText("");
        txtEstatus.setText("");
    }

}
