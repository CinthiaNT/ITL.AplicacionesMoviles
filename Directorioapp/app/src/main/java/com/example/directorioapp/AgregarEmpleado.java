package com.example.directorioapp;

import android.app.Person;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;

import com.example.directorioapp.Model.Empleado;

import java.util.ArrayList;
import java.util.Locale;
import com.example.directorioapp.MainActivity;

public class AgregarEmpleado extends AppCompatActivity {
    EditText txtNombre,txtapellidoP,txtapellidoM,txtTelefono,txtFechaNa,txtCorreo,txtDireccion,txtEstadoCivil,
    txtNomina,txtCurp,txtRfc,txtNss,txtArea,txtPuesto,txtEscolaridad,txtEnfermedadesCronicas,
    txtContactoEmergencia,txtEstatus;
    Button btnAgregar,btnModificar;
    public SQLiteDatabase sqldb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_agregar_empleado);
            txtNombre = (EditText) findViewById(R.id.txtNombre);
            txtapellidoP = (EditText)findViewById(R.id.txtApellidoP);
            txtapellidoM =(EditText)findViewById(R.id.txtApellidoM);
            txtTelefono = (EditText) findViewById(R.id.txtTelefono);
            txtFechaNa = (EditText)findViewById(R.id.txtFechaNa);
            txtCorreo = (EditText)findViewById(R.id.txtCorreo);
            txtDireccion =(EditText)findViewById(R.id.txtDireccion);
            txtEstadoCivil = (EditText)findViewById(R.id.txtEstadoCivil);
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
            btnAgregar=(Button) findViewById(R.id.btnAgegar);
            btnModificar=(Button) findViewById(R.id.btnModificar);
            sqldb = openOrCreateDatabase("directorioDb", Context.MODE_PRIVATE,null);
            mostrarEmpleado();
    }
    public void mostrarEmpleado(){
        Cursor c=sqldb.rawQuery("SELECT * FROM empleado WHERE nomina='"+getIntent().getExtras().getString("id")+"'", null);
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
            txtCurp.setText(c.getString(9));
            txtRfc.setText(c.getString(10));
            txtNss.setText(c.getString(11));
            txtArea.setText(c.getString(12));
            txtPuesto.setText(c.getString(13));
            txtEscolaridad.setText(c.getString(14));
            txtEnfermedadesCronicas.setText(c.getString(15));
            txtContactoEmergencia.setText(c.getString(16));
            txtEstatus.setText(c.getString(17));
        }
        else
        {
            showMessage("Error!", "Verifique numero de nomina");
            clearText();
        }
        return;
    }
    public void onClick(View view){
        if(view==btnAgregar) {
                if(txtNombre.getText().toString().trim().length()==0 || txtapellidoP.getText().toString().trim().length()==0 ||
                        txtapellidoM.getText().toString().trim().length()==0 || txtTelefono.getText().toString().trim().length()==0 ||
                        txtFechaNa.getText().toString().trim().length()==0 || txtDireccion.getText().toString().trim().length()==0 ||
                        txtNomina.getText().toString().trim().length()==0) {
                            showMessage("Error","Favor de llenar todos los campos");
                            return;
                }else{
                        crearEmpleado();
                }
        }else if(view == btnModificar){
                if(txtNomina.getText().toString().trim().length() == 0){
                    showMessage("Error!","Se necesito un Identificador de empleado");
                    return;
                }else{
                    editarEmpleado();
                }
        }
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void crearEmpleado(){
        Empleado empleado = new Empleado(txtNombre.getText().toString(),
                txtapellidoP.getText().toString(),
                txtapellidoM.getText().toString(),
                txtTelefono.getText().toString(),
                txtFechaNa.getText().toString(),
                txtCorreo.getText().toString(),
                txtDireccion.getText().toString(),
                txtEstadoCivil.getText().toString(),
                txtNomina.getText().toString(),
                txtCurp.getText().toString(),
                txtRfc.getText().toString(),
                txtNss.getText().toString(),
                txtArea.getText().toString(),
                txtPuesto.getText().toString(),
                txtEscolaridad.getText().toString(),
                txtEnfermedadesCronicas.getText().toString(),
                txtContactoEmergencia.getText().toString(),
                txtEstatus.getText().toString());
        sqldb.execSQL("INSERT INTO empleado VALUES('"+empleado.getNombre()+"','"
                +empleado.getApellido_p()+"','"
                +empleado.getApellido_m()+"','"
                +empleado.getTelefono()+"','"
                +empleado.getFecha_nacimiento()+"','"
                +empleado.getCorreo()+"','"
                +empleado.getDireccion()+"','"
                +empleado.getEstado_civil()+"','"
                +empleado.getNo_nomnina()+"','"
                +empleado.getCurp()+"','"
                +empleado.getRfc()+"','"
                +empleado.getNss()+"','"
                +empleado.getArea()+"','"
                +empleado.getPuesto()+"','"
                +empleado.getEscolaridad()+"','"
                +empleado.getEnfermedades_cronicas()+"','"
                +empleado.getContacto_emergencia()+"','"
                +empleado.getEstatus()+"');");
        showMessage("Exito!","Empleado registrado con exito"+ empleado.getNo_nomnina());
        clearText();
    }
    public void editarEmpleado(){
        Empleado empleado = new Empleado(txtNombre.getText().toString(),
                txtapellidoP.getText().toString(),
                txtapellidoM.getText().toString(),
                txtTelefono.getText().toString(),
                txtFechaNa.getText().toString(),
                txtCorreo.getText().toString(),
                txtDireccion.getText().toString(),
                txtEstadoCivil.getText().toString(),
                txtNomina.getText().toString(),
                txtCurp.getText().toString(),
                txtRfc.getText().toString(),
                txtNss.getText().toString(),
                txtArea.getText().toString(),
                txtPuesto.getText().toString(),
                txtEscolaridad.getText().toString(),
                txtEnfermedadesCronicas.getText().toString(),
                txtContactoEmergencia.getText().toString(),
                txtEstatus.getText().toString());
        sqldb.execSQL("UPDATE empleado SET nombre='"+empleado.getNombre()+"',"+
                "apellidoP ='"+empleado.getApellido_p()
                +"',apellidoM='"+empleado.getApellido_m()
                +"',telefono='"+empleado.getTelefono()
                +"',fechaNacimiento='"+empleado.getFecha_nacimiento()
                +"',correo='"+empleado.getCorreo()
                +"',direccion='"+empleado.getDireccion()+"'"
                +",estadoCivil='"+empleado.getEstado_civil()+"'"
                +",nomina='"+empleado.getNo_nomnina()+"'"
                +",curp='"+empleado.getCurp()+"'"
                +",rfc='"+empleado.getRfc()+"'"
                +",nss='"+empleado.getNss()+"'"
                +",area='"+empleado.getArea()+"'"
                +",puesto='"+empleado.getPuesto()+"'"
                +",escolaridad='"+empleado.getEscolaridad()+"'"
                +",enfermedades='"+empleado.getEnfermedades_cronicas()+"'"
                +",contacto='"+empleado.getContacto_emergencia()+"'"
                +",estatus='"+empleado.getEstatus()+"'"
                +"WHERE nomina='" + empleado.getNo_nomnina() + "'");
        showMessage("Exito!", "Empleado actualizado con exito "+empleado.getNo_nomnina());
        clearText();
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