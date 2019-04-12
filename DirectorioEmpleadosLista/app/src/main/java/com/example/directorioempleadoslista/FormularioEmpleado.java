package com.example.directorioempleadoslista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FormularioEmpleado extends AppCompatActivity {
    private EditText txtNombre,txtApellidoP,txtApellidoM,txtNomina,txtTelefono;
    private Button btnGuardar, btnCancelar;
    private Intent main;
    private ArrayList<Empleado> listaEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_empleado);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellidoP = (EditText) findViewById(R.id.txtApellidoP);
        txtApellidoM = (EditText) findViewById(R.id.txtApellidoM);
        txtNomina = (EditText) findViewById(R.id.txtNomina);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);

        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btnCancelar = (Button)findViewById(R.id.btnCancelar);

        if(getIntent().hasExtra("listaEmpleado")){
            listaEmpleado = (ArrayList<Empleado>)
                    getIntent().getExtras().getSerializable("listaEmpleado");
        }
    }

    public void enviarEmpleado(View view){
        //TODO: VALIDAR QUE NOS CAMPOS NO ESTEN VACIOS
        if(!this.validarVacios()){
            Toast.makeText(this, "Debes ingresar todos los campos", Toast.LENGTH_LONG).show();
        }else{
            listaEmpleado.add(new Empleado(
                              txtNombre.getText().toString().trim(),
                              txtApellidoP.getText().toString().trim(),
                              txtApellidoM.getText().toString().trim(),
                              Integer.valueOf(txtNomina.getText().toString().trim()),
                              txtTelefono.getText().toString().trim()
                              ));

        }
        main = new Intent(this,MainActivity.class);
        main.putExtra("listaEmpledo", this.listaEmpleado);
        startActivity(main);

    }
    public void cancelar (View view){
        main.putExtra("listaEmpleado", this.listaEmpleado);
        startActivity(main);
    }
    ///////////////////////////////Metodos privados//////////////////////////////////////////////
    private boolean validarVacios(){
        return  (txtNombre.getText().toString().trim().length() > 0
           && txtApellidoP.getText().toString().trim().length() > 0
                && txtApellidoM.getText().toString().trim().length() > 0
                && txtNomina.getText().toString().trim().length() > 0
                && txtTelefono.getText().toString().trim().length() > 0);
    }
}
